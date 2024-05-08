package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.DTO.ProductItemFullInfo;
import dannelysbeth.ecommerce.mongodbshop.model.Order;
import dannelysbeth.ecommerce.mongodbshop.model.Product;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

public interface ProductService {

    Set<Product> getProducts(Double priceStartsAt, Double priceEndsAt, Long quantity, List<String> category, List<String> color, List<String> size);
    void importFromFile(MultipartFile file);

    void saveMany(Set<Product> products);

    ProductItem getProductItemById(String productItemCode);

    ProductItemFullInfo getFullProductItemInfo(String productItemCode);

    void decreaseProductItems(Order order);

}
