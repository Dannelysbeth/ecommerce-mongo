package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

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
}
