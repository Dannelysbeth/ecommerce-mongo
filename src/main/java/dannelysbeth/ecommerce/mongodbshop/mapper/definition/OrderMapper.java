package dannelysbeth.ecommerce.mongodbshop.mapper.definition;

import dannelysbeth.ecommerce.mongodbshop.model.*;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.OrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderMapper {
    Order initOrder(User user);

    Order updateOrderFromRequest(Order order, Set<Item> items, Address address, ShippingMethod shippingMethod);

    Set<OrderResponse> transformToOrderResponse(Set<Order> order);

    Item getItemFromCart(Item item, ProductItem productItem);
}
