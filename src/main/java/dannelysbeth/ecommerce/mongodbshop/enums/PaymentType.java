package dannelysbeth.ecommerce.mongodbshop.enums;

import lombok.Getter;

@Getter
public enum PaymentType {
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    PAYPAL("PayPal"),
    GOOGLE_PAY("Google Pay"),
    APPLE_PAY("Apple Pay"),
    CASH_ON_DELIVERY("Cash on Delivery");

    private final String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

}
