package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class ShippingMethod {

    @Id
    private String id;

    private String name;

    private double price;
}
