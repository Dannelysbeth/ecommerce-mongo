package dannelysbeth.ecommerce.mongodbshop.repository;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Cart getByUser_Username(String username);
}
