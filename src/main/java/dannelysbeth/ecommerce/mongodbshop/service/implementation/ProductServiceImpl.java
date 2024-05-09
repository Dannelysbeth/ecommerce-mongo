package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.factory.definition.JsonProductMapper;
import dannelysbeth.ecommerce.mongodbshop.filters.ProductSpecification;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.ProductMapper;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.ProductItemFullInfo;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.ProductRequest;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import dannelysbeth.ecommerce.mongodbshop.model.Order;
import dannelysbeth.ecommerce.mongodbshop.model.Product;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import dannelysbeth.ecommerce.mongodbshop.repository.ProductRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final MongoTemplate mongoTemplate;
    private final JsonProductMapper jsonFactory;
    private final ProductMapper mapper;

    private StopWatch watch = new StopWatch();

    public double getRepositoryResponseTime() {
        return this.watch.getTotalTimeMillis();
    }


    @Override
    public Set<Product> getProducts(Double priceStartsAt, Double priceEndsAt, Long quantity, List<String> category, List<String> color, List<String> size) {
        Query query = ProductSpecification.filterBy(priceStartsAt, priceEndsAt, quantity, category, color, size);
        this.watch = new StopWatch();
        this.watch.start();
        List<Product> products = mongoTemplate.find(query, Product.class);
        this.watch.stop();
        return new HashSet<>(products);
    }

    @Override
    public void importFromFile(MultipartFile file) {
        List<ProductRequest> productRequests = this.jsonFactory.readFromFile(file);
        Set<Product> products = this.mapper.transformFromRequest(productRequests);

        this.saveMany(products);
    }

    @Override
    public void saveMany(Set<Product> products) {
        if (products == null || products.isEmpty()) {
            return;
        }
        for (Product product : products) {
            Product foundProduct = repository.getById(product.getId());
            if (foundProduct == null) {
                repository.save(product);
            } else {
                foundProduct.addNewItems(product.getItems());
                repository.save(foundProduct);
            }
        }
    }

    @Override
    public ProductItem getProductItemById(String productItemCode) {
        Product product = this.repository.getByItems_id(productItemCode);
        return product.getProductById(productItemCode);
    }

    @Override
    public ProductItemFullInfo getFullProductItemInfo(String productItemCode) {
        Product product = this.repository.getByItems_id(productItemCode);
        ProductItem productItem = product.getProductById(productItemCode);
        return ProductItemFullInfo.builder()
                .productCode(product.getId())
                .description(product.getDescription())
                .name(product.getName())
                .category(product.getCategory())
                .price(productItem.getPrice())
                .productItemCode(productItemCode)
                .quantityInStock(productItem.getQuantityInStock())
                .features(productItem.getFeatures())
                .sku(productItem.getSKU())
                .build();
    }

    @Override
    public void decreaseProductItems(Order order) {
        Set<Item> items = order.getItems();

        for (Item item : items) {
            Product product = this.repository.getByItems_id(item.getId());
            product.decreaseProductById(item.getId(), item.getQuantity());
            this.repository.save(product);
        }
    }

}
