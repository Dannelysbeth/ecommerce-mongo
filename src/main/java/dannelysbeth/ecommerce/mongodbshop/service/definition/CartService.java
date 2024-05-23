package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import dannelysbeth.ecommerce.mongodbshop.model.User;

public interface CartService {

    double getRepositoryResponseTime();

    void saveCart(Cart cart);

    Cart getCartByUser(User user);

    void addItemToCart(Cart cart, Item item);

    void emptyCart(Cart cart);


}
