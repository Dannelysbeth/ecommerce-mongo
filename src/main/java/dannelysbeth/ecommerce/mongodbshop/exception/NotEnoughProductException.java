package dannelysbeth.ecommerce.mongodbshop.exception;

import dannelysbeth.ecommerce.mongodbshop.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class NotEnoughProductException extends BusinessException {
    public NotEnoughProductException() {
        super("Not enough products in store", HttpStatus.NOT_ACCEPTABLE.value());
    }
}
