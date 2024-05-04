package dannelysbeth.ecommerce.mongodbshop.api;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.AddressMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Country;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.AddressRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.AddressResponse;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.service.definition.CountryService;
import dannelysbeth.ecommerce.mongodbshop.service.definition.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("api/address")
public class AddressController {

    private final CountryService countryService;
    private final UserService userService;
    private final AddressMapper addressMapper;

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE')")
    @GetMapping()
    public ResponseEntity<Set<AddressResponse>> getAddresses(@RequestParam(required = false) String username) {

        User user;
        if (username == null) {
            user = userService.getLoggedUser();
        } else {
            user = userService.getByUsername(username);
        }

        User finalUser = user;
        return ResponseEntity.ok()
                .body(userService.getAddressesByUserAddresses(finalUser)
                        .stream()
                        .map(addr -> addressMapper.transformAddressToResponse(addr, finalUser))
                        .collect(Collectors.toSet()));
    }

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE', 'USER_ROLE')")
    @PostMapping("/create")
    public ResponseEntity<String> saveOwnAddresses(@RequestBody AddressRequest request) {
        Country country = countryService.getCountryByCode(request.getCountry());
        User loggedUser = userService.getLoggedUser();
        userService.addAddressToUser(loggedUser, addressMapper.tranformRequestToAddress(request, country));
        return ResponseEntity.ok()
                .body("Address successfully saved");
    }
}
