package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ProductService {
    void importFromFile(MultipartFile file);

    void saveMany(Set<Product> products);

}
