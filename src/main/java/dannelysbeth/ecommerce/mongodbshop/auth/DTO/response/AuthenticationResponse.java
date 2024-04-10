package dannelysbeth.ecommerce.mongodbshop.auth.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {
    private String token;
}
