package dannelysbeth.ecommerce.mongodbshop.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PENDING("Pending Payment"),
    PROCESSING("Processing"),
    SHIPPED("Shipped"),
    DELIVERED("Delivered"),
    CANCELED("Canceled");

    private final String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }

}
