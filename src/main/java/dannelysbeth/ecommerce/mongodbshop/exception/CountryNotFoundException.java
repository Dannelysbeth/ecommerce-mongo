package dannelysbeth.ecommerce.mongodbshop.exception;

import org.springframework.http.HttpStatus;

public class CountryNotFoundException extends BusinessException {
    public CountryNotFoundException() {
        super("Country not found", HttpStatus.NOT_FOUND.value());
    }
}
