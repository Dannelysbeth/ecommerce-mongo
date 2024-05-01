package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import dannelysbeth.ecommerce.mongodbshop.model.Feature;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CartItemResponse {

    String productCode;

    String name;

    String category;

    String description;

    double price;

    Set<Feature> featureSet;

    long quantity;
}
