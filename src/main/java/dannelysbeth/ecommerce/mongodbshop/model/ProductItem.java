package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document
public class ProductItem {

    @Id
    private String id;

    private Product product;

    private long quantityInStock;

    private long SKU;

    private List<Variation> variation;
}
