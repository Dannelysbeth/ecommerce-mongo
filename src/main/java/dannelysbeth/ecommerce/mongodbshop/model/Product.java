package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private double price;

    private String category;

    Set<ProductItem> items;

}
