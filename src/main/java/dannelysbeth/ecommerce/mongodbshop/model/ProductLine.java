package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class ProductLine {

    @Id
    private String id;

    private ProductItem product;

    private int quantityInStock;

    private int SKU;
}
