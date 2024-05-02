package dannelysbeth.ecommerce.mongodbshop.exception;


import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException(String username) {
        super(STR. "user \{ username } not found" ,
                HttpStatus.NOT_FOUND.value());
    }

    public UserNotFoundException() {
        super("User for given username not found",
                HttpStatus.NOT_FOUND.value());
    }

}
