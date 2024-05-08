package dannelysbeth.ecommerce.mongodbshop.mapper.implementation;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.OrderMapper;
import dannelysbeth.ecommerce.mongodbshop.model.*;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.AddressDto;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.OrderResponse;
import dannelysbeth.ecommerce.mongodbshop.model.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order initOrder(User user) {
        return Order.builder()
                .orderDate(new Date())
                .orderStatus(OrderStatus.CREATED)
                .user(user)
                .build();
    }

    @Override
    public Order updateOrderFromRequest(Order order, Set<Item> items, AddressDto shippingAddress, ShippingMethod shippingMethod) {
        return Order.builder()
                .id(order.getId())
                .orderStatus(order.getOrderStatus() == null ? OrderStatus.CREATED : order.getOrderStatus())
                .orderDate(order.getOrderDate() == null ? new Date() : order.getOrderDate())
                .shippingMethod(shippingMethod)
                .shippingAddress(shippingAddress)
                .items(items)
                .user(order.getUser())
                .total(countTotalPrice(items, shippingMethod))
                .build();
    }

    @Override
    public Set<OrderResponse> transformToOrderResponse(Set<Order> orders) {
        return orders.stream().map(order->OrderResponse
                .builder()
                .shippingAddress(order.getShippingAddress())
                .username(order.getUser().getUsername())
                .orderStatus(order.getOrderStatus().getDisplayName())
                .orderDate(order.getOrderDate())
                .items(order.getItems())
                .total(order.getTotal())
                .shippingMethod(order.getShippingMethod() == null ? "None chosen" : order.getShippingMethod().getName())
                .build()
        ).collect(Collectors.toSet());
    }

    @Override
    public Item getItemFromCart(Item item, ProductItem productItem) {
        item.setPrice(productItem.getPrice());
        return item;
    }

    private double countTotalPrice(Set<Item> orderItems, ShippingMethod  shippingMethod) {
        double sum = 0;
        if (orderItems != null) {
            for (Item orderItem : orderItems) {
                sum += orderItem.getPrice() * orderItem.getQuantity();
            }
        }
        if (shippingMethod != null) {
            sum += shippingMethod.getPrice();
        }
        return sum;
    }
}
