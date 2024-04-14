package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Product {

    private String productCode;

    private String name;

    private String description;

    private double price;

    private String category;

}
