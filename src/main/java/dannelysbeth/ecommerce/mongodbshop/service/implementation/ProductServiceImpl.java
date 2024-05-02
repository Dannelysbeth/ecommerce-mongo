package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.factory.definition.JsonProductMapper;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.ProductMapper;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.ProductRequest;
import dannelysbeth.ecommerce.mongodbshop.model.Product;
import dannelysbeth.ecommerce.mongodbshop.repository.ProductRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final JsonProductMapper jsonFactory;
    private final ProductMapper mapper;

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

}
