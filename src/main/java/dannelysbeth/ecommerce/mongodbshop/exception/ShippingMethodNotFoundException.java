package dannelysbeth.ecommerce.mongodbshop.exception;

import org.springframework.http.HttpStatus;

public class ShippingMethodNotFoundException extends BusinessException {
    public ShippingMethodNotFoundException() {
        super("Shipping method not found", HttpStatus.NOT_FOUND.value());
    }
}
