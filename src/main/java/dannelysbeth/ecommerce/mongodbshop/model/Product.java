package dannelysbeth.ecommerce.mongodbshop.model;

import dannelysbeth.ecommerce.mongodbshop.exception.NotEnoughProductException;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
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
    private long _currentSeqValue;

    public void addNewItems(Set<ProductItem> productItems) {
        if (productItems == null || productItems.isEmpty()) {
            return;
        }
        for (ProductItem item : productItems) {
            if (this.items == null) {
                this.items = new HashSet<>();
            }
            item.setId(this.id + "-" + this._currentSeqValue);
            this.items.add(item);
            this._currentSeqValue++;
        }
    }


    public ProductItem getProductById(String id) {
        if (this.items == null || this.items.isEmpty()) {
            return null;
        }
        for (ProductItem item : this.items) {
            if (Objects.equals(item.getId(), id)) {
                return item;
            }
        }
        return null;
    }

    public void decreaseProductById(String productId, long quantity) {
        ProductItem productItem = this.items.stream().filter(prodItem -> Objects.equals(prodItem.getId(), productId)).findAny().orElse(null);
        if (productItem == null) {
            return;
        }

        long newQuantityInStock = productItem.getQuantityInStock() - quantity;
        if (newQuantityInStock < 0) {
            throw new NotEnoughProductException();
        }
        this.items.remove(productItem);
        productItem.setQuantityInStock(newQuantityInStock);
        this.items.add(productItem);
    }


}
