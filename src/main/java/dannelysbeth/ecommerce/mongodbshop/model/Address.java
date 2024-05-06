package dannelysbeth.ecommerce.mongodbshop.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Builder
@Data
public class Address {

    private long id;

    @DBRef
    private Country country;

    private int unitNumber;

    private int streetNumber;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String postalCode;

    private boolean isDefault;

}
