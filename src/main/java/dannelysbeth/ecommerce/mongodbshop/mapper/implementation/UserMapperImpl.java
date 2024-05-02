package dannelysbeth.ecommerce.mongodbshop.mapper.implementation;


import dannelysbeth.ecommerce.mongodbshop.mapper.definition.UserMapper;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.UserRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.UserResponse;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.model.enums.Role;
import org.springframework.stereotype.Component;


@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public User tranformRequestToUser(UserRequest request, String encodedPassword, Role role) {
        return User.builder()
                .role(role)
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(encodedPassword)
                .build();
    }

    @Override
    public UserResponse transformUserToResponse(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .build();
    }
}
