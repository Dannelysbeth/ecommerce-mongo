package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.repository.CartRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository repository;

    @Override
    public void saveCart(Cart cart) {
        repository.save(cart);
    }

    @Override
    public Cart getCartByUser(User user) {
        Cart cart = repository.getByUser(user);
        if (cart == null)
            cart = repository.save(Cart.builder()
                    .user(user)
                    .build());
        return cart;
    }

    @Override
    public void addItemToCart(Cart cart, Item item) {
        cart.addCartItem(item);
        repository.save(cart);
    }

    @Override
    public void emptyCart(Cart cart) {
        cart.setItems(null);
        cart.setTotal(0);
        repository.save(cart);
    }
}
