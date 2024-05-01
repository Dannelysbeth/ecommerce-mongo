package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductItem {

    private long quantityInStock;

    private String sku;

    private Set<Feature> features;

    private double price;
}
