package dannelysbeth.ecommerce.mongodbshop.model.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    private String country;

    private int unitNumber;

    private int streetNumber;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String postalCode;
}
