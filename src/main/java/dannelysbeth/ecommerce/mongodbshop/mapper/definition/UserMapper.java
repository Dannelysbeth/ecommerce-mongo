package dannelysbeth.ecommerce.mongodbshop.mapper.definition;


import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.UserRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.UserResponse;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.model.enums.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    User tranformRequestToUser(UserRequest request, String encodedPassword, Role role);

    UserResponse transformUserToResponse(User user);
}
