package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.OrderMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Order;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.repository.OrderRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    @Override
    public Set<Order> getOrdersByUser(User user) {
        return repository.getOrdersByUser(user);
    }

    @Override
    public Order createOrder(User user) {
       return orderMapper.initOrder(user);
    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void deleteOrder(Order order) {

    }
}
