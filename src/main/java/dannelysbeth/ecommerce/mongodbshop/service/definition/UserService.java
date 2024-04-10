package dannelysbeth.ecommerce.mongodbshop.service.definition;


import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.UserRequest;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface UserService {

    User getUserById(String id);

    User getLoggedUser();

    User getByUsername(String username);

    Set<User> findAllUsers(String firstname, String lastname);

    void importUsers(Set<UserRequest> requests);
}
