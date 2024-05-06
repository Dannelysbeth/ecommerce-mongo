package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@Builder
public class Item {

    @Id
    private String id;

    private String productCode;

    private String name;

    private String description;

    private double price;

    private String category;

    private String sku;

    private Set<Feature> features;

    private int quantity;
}
