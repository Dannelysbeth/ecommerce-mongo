package dannelysbeth.ecommerce.mongodbshop.model.DTO;

import dannelysbeth.ecommerce.mongodbshop.model.Feature;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductItemFullInfo {

    private String productItemCode;

    private String productCode;

    private String name;

    private String description;

    private double price;

    private String category;

    private String sku;

    private Set<Feature> features;

    private long quantityInStock;
}
