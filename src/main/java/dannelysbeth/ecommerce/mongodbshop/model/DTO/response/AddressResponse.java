package dannelysbeth.ecommerce.mongodbshop.model.DTO.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class AddressResponse {

    String country;

    int unitNumber;

    int streetNumber;

    String addressLine1;

    String addressLine2;

    String city;

    String postalCode;

    boolean isDefault;

    @Builder
    public static class Person {
        String firstname;
        String lastname;
    }
}
