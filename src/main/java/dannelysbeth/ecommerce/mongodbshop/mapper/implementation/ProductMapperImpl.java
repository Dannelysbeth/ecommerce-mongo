package dannelysbeth.ecommerce.mongodbshop.mapper.implementation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dannelysbeth.ecommerce.mongodbshop.exception.FileInputException;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.ProductMapper;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public List<ProductItem> readFromFile(MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(file.getInputStream(),
                    new TypeReference<>() {
                    });

        } catch (IOException e) {
            throw new FileInputException(e.getMessage());
        }
    }
}
