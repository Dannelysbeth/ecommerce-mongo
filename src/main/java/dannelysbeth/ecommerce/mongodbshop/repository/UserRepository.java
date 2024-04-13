package dannelysbeth.ecommerce.mongodbshop.repository;


import dannelysbeth.ecommerce.mongodbshop.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> getUserByUsername(String username);

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

}
