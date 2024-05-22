package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Order;
import dannelysbeth.ecommerce.mongodbshop.model.User;

import java.util.Set;

public interface OrderService {

    double getRepositoryResponseTime();

    Set<Order> getOrdersByUser(User user);

    Order createOrder(User user);

    void updateOrder(Order order);

    void deleteOrder(Order order);
}
