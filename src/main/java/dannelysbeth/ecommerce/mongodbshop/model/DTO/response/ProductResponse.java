package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ProductResponse {

    String productCode;

    String name;

    String category;

    String description;

    double price;

    Set<ProductItem> productItems;
}
