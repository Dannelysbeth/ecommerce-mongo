package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.DTO.ProductItemFullInfo;
import dannelysbeth.ecommerce.mongodbshop.model.Product;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ProductService {
    void importFromFile(MultipartFile file);

    void saveMany(Set<Product> products);

    ProductItem getProductItemById(String productItemCode);

    ProductItemFullInfo getFullProductItemInfo(String productItemCode);

}
