package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.ProductMapper;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import dannelysbeth.ecommerce.mongodbshop.repository.ProductRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public List<ProductItem> importFromFile(MultipartFile file) {
        List<ProductItem> products = this.productMapper.readFromFile(file);
        return this.productRepository.saveAll(products);
    }
}
