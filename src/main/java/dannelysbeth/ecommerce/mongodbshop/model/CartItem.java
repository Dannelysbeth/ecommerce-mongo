package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CartItem {

    private String sku;

    private Set<Feature> features;

    private double price;

    private int quantity;
}
