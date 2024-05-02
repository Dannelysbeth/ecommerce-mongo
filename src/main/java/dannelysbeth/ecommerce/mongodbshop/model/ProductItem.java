package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Set;

@Data
@Builder
public class ProductItem {

    @Id
    private String id;

    private long quantityInStock;

    private String SKU;

    private Set<Feature> features;

    private double price;
}
