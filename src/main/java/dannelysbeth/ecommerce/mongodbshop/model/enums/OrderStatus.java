package dannelysbeth.ecommerce.mongodbshop.model.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED("Created"),
    PENDING("Pending Payment"),
    PROCESSING("Processing"),
    PAID("Paid"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

}
