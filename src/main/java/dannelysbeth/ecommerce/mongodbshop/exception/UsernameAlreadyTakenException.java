package dannelysbeth.ecommerce.mongodbshop.exception;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyTakenException extends BusinessException {
    public UsernameAlreadyTakenException() {
        super("Username is already taken", HttpStatus.NOT_ACCEPTABLE.value());
    }
}
