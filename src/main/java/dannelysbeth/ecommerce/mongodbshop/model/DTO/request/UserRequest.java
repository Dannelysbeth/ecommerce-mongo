package dannelysbeth.ecommerce.mongodbshop.model.DTO.request;

import lombok.Data;

@Data
public class UserRequest {
    private String firstname;

    private String lastname;

    private String email;

    private String username;

}
