package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import dannelysbeth.ecommerce.mongodbshop.model.CartItem;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class CartResponse {

    String username;

    Set<CartItem> items;

    double total;
}
