package dannelysbeth.ecommerce.mongodbshop.model;

import dannelysbeth.ecommerce.mongodbshop.model.enums.OrderStatus;
import dannelysbeth.ecommerce.mongodbshop.model.enums.PaymentType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
public class Order {

    @Id
    private String id;

    @DBRef
    private User user;

    private Address shippingAddress;

    private OrderStatus orderStatus;

    private Date orderDate;

    private double total;

    @DBRef
    private ShippingMethod shippingMethod;

    private PaymentType paymentType;


}
