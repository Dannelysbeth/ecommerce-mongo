package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Document
@Builder
public class Cart {
    @Id
    private String id;

    @DBRef
    private User user;

    private Set<CartItem> items;

    private double total;

    public void addCartItem(CartItem item) {
        if (item == null) {
            return;
        }
        if (items == null) {
            this.items = new HashSet<>();
            items.add(item);
        } else {
            CartItem foundItem = this.items.stream()
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
        if((this.items != null && !this.items.isEmpty())) {
          for (var item : this.items) {
              sum += item.getQuantity() * item.getPrice();
          }
        }
        this.total = sum;
    }

}
