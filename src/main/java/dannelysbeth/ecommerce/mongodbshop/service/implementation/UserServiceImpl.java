package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.auth.AuthService;
import dannelysbeth.ecommerce.mongodbshop.exception.AddressNotFoundException;
import dannelysbeth.ecommerce.mongodbshop.exception.UserNotFoundException;
import dannelysbeth.ecommerce.mongodbshop.model.Address;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.UserRequest;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.repository.UserRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthService authService;


    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public User getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return this.getByUsername(username);
        }
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getUserByUsername(username).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Set<User> findAllUsers(String firstname, String lastname) {
        return new HashSet<>(userRepository.findAll());
    }

    @Override
    public void importUsers(Set<UserRequest> requests) {
        this.authService.importMultipleUsers(requests);
    }

    @Override
    public Set<Address> getAddressesByUserAddresses(User user) {
        return user.getAddresses();
    }

    @Override
    public Address getAddressByUserAndId(User user, long id) {
        return user.getAddresses().stream()
                .filter(addr -> addr.getId() == id)
                .findAny()
                .orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public void addAddressToUser(User user, Address address) {
        user.addAddress(address);
        userRepository.save(user);
    }

}