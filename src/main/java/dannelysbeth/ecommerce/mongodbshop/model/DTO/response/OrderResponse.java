package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class OrderResponse {

    String username;

    Set<CartItemResponse> items;

    double total;

    AddressResponse shippingAddress;

    String orderStatus;

    String shippingMethod;

    Date orderDate;

}
