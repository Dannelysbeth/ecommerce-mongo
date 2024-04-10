package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Country {

    @Id
    private String id;

    @Indexed(unique = true)
    private String country;
}
