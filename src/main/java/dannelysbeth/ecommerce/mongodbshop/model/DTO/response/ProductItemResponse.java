package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import dannelysbeth.ecommerce.mongodbshop.model.Feature;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductItemResponse {

    double price;

    Set<Feature> featureSet;

    long quantityInStock;

    String SKU;

}
