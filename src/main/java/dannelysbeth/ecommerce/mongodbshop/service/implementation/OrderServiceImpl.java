package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.OrderMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Order;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.repository.OrderRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final OrderMapper orderMapper;
    private StopWatch watch;

    public double getRepositoryResponseTime() {
        return this.watch.getTotalTimeMillis();
    }

    @Override
    public Set<Order> getOrdersByUser(User user) {
        watch = new StopWatch();
        watch.start();
        Set<Order> orders = repository.getOrdersByUser(user);
        watch.stop();
        return orders;
    }

    @Override
    public Order createOrder(User user) {
        watch = new StopWatch();
        watch.start();
        Order order = orderMapper.initOrder(user);
        watch.stop();
        return order;
    }

    @Override
    public void updateOrder(Order order) {
        watch = new StopWatch();
        watch.start();
        repository.save(order);
        watch.stop();
    }

    @Override
    public void deleteOrder(Order order) {
        watch = new StopWatch();
        watch.start();
        repository.delete(order);
        watch.stop();
    }
}
