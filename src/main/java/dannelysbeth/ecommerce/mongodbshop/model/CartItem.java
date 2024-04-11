package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {

    private ProductItem item;

    private int quantity;
}
