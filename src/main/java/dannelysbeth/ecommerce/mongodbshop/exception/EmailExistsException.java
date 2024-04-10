package dannelysbeth.ecommerce.mongodbshop.exception;

import org.springframework.http.HttpStatus;

public class EmailExistsException extends BusinessException {
    public EmailExistsException() {
        super("Email is already taken", HttpStatus.NOT_ACCEPTABLE.value());
    }
}
