package dannelysbeth.ecommerce.mongodbshop.api.handlers;


import dannelysbeth.ecommerce.mongodbshop.api.handlers.DTO.ErrorResponse;
import dannelysbeth.ecommerce.mongodbshop.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorResponse handleAnyException(AccessDeniedException exception, WebRequest request) {
        return new ErrorResponse(new BusinessException(exception.getMessage(), HttpStatus.FORBIDDEN.value()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(UsernameAlreadyTakenException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleUsernameAlreadyTakenException(UsernameAlreadyTakenException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(EmailExistsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleEmailExistsException(EmailExistsException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    public ErrorResponse handleIncorrectPasswordException(IncorrectPasswordException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(FileInputException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse handleFileInputException(FileInputException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleAddressNotFoundException(AddressNotFoundException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleCountryNotFoundException(CountryNotFoundException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(PaymentMethodNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handlePaymentMethodNotFoundException(PaymentMethodNotFoundException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(ShippingMethodNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleShippingMethodNotFoundException(ShippingMethodNotFoundException exception) {
        return new ErrorResponse(exception);
    }

    @ExceptionHandler(NotEnoughProductException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse handleNotEnoughProductException(NotEnoughProductException exception) {
        return new ErrorResponse(exception);
    }
}
