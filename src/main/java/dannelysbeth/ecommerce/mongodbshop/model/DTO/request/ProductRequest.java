package dannelysbeth.ecommerce.mongodbshop.model.DTO.request;

import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import lombok.Builder;
import lombok.Data;

import java.util.Set;


@Data
@Builder
public class ProductRequest {

    String productCode;

    String name;

    String category;

    String description;

    double price;

    Set<ProductItem> productItems;

}




