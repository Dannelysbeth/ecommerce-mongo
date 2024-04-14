package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
public interface ProductService {
    void importFromFile(MultipartFile file);
}
