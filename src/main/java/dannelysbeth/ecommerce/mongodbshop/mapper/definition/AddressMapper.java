package dannelysbeth.ecommerce.mongodbshop.mapper.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Address;
import dannelysbeth.ecommerce.mongodbshop.model.Country;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.AddressRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.AddressResponse;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {

    Address tranformRequestToAddress(AddressRequest addressRequest, Country country);

    AddressResponse transformAddressToResponse(Address address, User user);
}
