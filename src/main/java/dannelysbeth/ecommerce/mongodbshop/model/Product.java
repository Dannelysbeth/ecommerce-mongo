package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Product {

    private String name;

    private String description;

    private double price;

    private byte[] image;

    private Category category;

    private Set<Variation> variations;

}
