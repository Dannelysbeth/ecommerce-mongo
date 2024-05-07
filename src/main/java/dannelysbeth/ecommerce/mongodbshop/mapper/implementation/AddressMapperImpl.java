package dannelysbeth.ecommerce.mongodbshop.mapper.implementation;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.AddressMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Address;
import dannelysbeth.ecommerce.mongodbshop.model.Country;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.AddressDto;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.AddressRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.AddressResponse;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {
    @Override
    public Address tranformRequestToAddress(AddressRequest addressRequest, Country country) {
        return Address.builder()
                .addressLine1(addressRequest.getAddressLine1())
                .addressLine2(addressRequest.getAddressLine2())
                .city(addressRequest.getCity())
                .country(country)
                .isDefault(false)
                .postalCode(addressRequest.getPostalCode())
                .streetNumber(addressRequest.getStreetNumber())
                .unitNumber(addressRequest.getUnitNumber())
                .build();
    }

    @Override
    public AddressResponse transformAddressToResponse(Address address, User user) {
        return AddressResponse.builder()
                .isDefault(address.isDefault())
                .country(address.getCountry().getCountry())
                .city(address.getCity())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .streetNumber(address.getStreetNumber())
                .postalCode(address.getPostalCode())
                .unitNumber(address.getUnitNumber())
                .build();
    }

    @Override
    public AddressDto transformAddressToDto(Address address) {
        return AddressDto.builder()
                .country(address.getCountry().getCountry())
                .city(address.getCity())
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .streetNumber(address.getStreetNumber())
                .postalCode(address.getPostalCode())
                .unitNumber(address.getUnitNumber())
                .build();
    }
}
