package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.CartItem;
import dannelysbeth.ecommerce.mongodbshop.model.User;

public interface CartService {

    void saveCart(Cart cart);

    Cart getCartByUser(User user);

    void addItemToCart(Cart cart, CartItem item);

    void emptyCart(Cart cart);


}
