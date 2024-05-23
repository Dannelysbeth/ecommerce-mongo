package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.repository.CartRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository repository;

    private final StopWatch watch = new StopWatch();

    @Override
    public double getRepositoryResponseTime() {
        return this.watch.getTotalTimeMillis();
    }

    @Override
    public void saveCart(Cart cart) {
        watch.start();
        repository.save(cart);
        watch.stop();
    }

    @Override
    public Cart getCartByUser(User user) {
        watch.start();
        Cart cart = repository.getByUser(user);
        if (cart == null)
            cart = repository.save(Cart.builder()
                    .user(user)
                    .build());
        watch.stop();
        return cart;
    }

    @Override
    public void addItemToCart(Cart cart, Item item) {
        cart.addCartItem(item);
        watch.start();
        repository.save(cart);
        watch.stop();
    }

    @Override
    public void emptyCart(Cart cart) {
        cart.setItems(null);
        cart.setTotal(0);
        watch.start();
        repository.save(cart);
        watch.stop();
    }
}
