package dannelysbeth.ecommerce.mongodbshop.model;

import dannelysbeth.ecommerce.mongodbshop.model.DTO.AddressDto;
import dannelysbeth.ecommerce.mongodbshop.model.enums.OrderStatus;
import dannelysbeth.ecommerce.mongodbshop.model.enums.PaymentType;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document
@Data
@Builder
public class Order {

    @Id
    private String id;

    @DBRef
    private User user;

    private AddressDto shippingAddress;

    private OrderStatus orderStatus;

    private Date orderDate;

    private double total;

    @DBRef
    private ShippingMethod shippingMethod;

    private PaymentType paymentType;

    private Set<Item> items;


    public void addItemToOrder(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (items == null) {
            this.items = new HashSet<>();
            items.add(item);
        } else {
            Item foundItem = this.items.stream()
                    .filter(i -> Objects.equals(i.getId(), item.getId()))
                    .findAny()
                    .orElse(null);

            if (foundItem != null) {
                int newQuantity = foundItem.getQuantity() + 1;
                this.items.remove(foundItem);
                foundItem.setQuantity(newQuantity);
                this.items.add(foundItem);
            } else {
                this.items.add(item);
            }
        }
        countTotal();
    }

    public void countTotal() {
        double sum = 0;
        if ((this.items != null && !this.items.isEmpty())) {
            for (var item : this.items) {
                sum += item.getQuantity() * item.getPrice();
            }
        }
        if (this.shippingMethod != null) {
            sum += this.shippingMethod.getPrice();
        }
        this.total = sum;
    }


    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
        this.countTotal();
    }
}
