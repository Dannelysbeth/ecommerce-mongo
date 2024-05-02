package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document
public class Product {

    Set<ProductItem> items;
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;

    public void addNewItems(Set<ProductItem> productItems) {
        if (productItems == null || productItems.isEmpty()) {
            return;
        }
        for (ProductItem item : productItems) {
            if (this.items == null) {
                this.items = new HashSet<>();
            }
            this.items.add(item);
        }
    }

}
