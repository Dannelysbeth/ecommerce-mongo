package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.CartItem;
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
        Cart cart = repository.getByUser_Username(user.getUsername());
        if (cart == null)
            cart = repository.save(Cart.builder()
                    .user(user)
                    .build());
        return cart;
    }

    @Override
    public void addItemToCart(Cart cart, CartItem cartItem) {

    }

    @Override
    public void emptyCart(Cart cart) {

    }
}
