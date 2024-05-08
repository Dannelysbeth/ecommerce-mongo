package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import dannelysbeth.ecommerce.mongodbshop.model.DTO.AddressDto;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Builder
public class OrderResponse {

    String username;

    Set<Item> items;

    double total;

    AddressDto shippingAddress;

    String orderStatus;

    String shippingMethod;

    Date orderDate;

}
