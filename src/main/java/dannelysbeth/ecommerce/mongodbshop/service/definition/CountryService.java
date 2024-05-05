package dannelysbeth.ecommerce.mongodbshop.service.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Country;

import java.util.Set;

public interface CountryService {
    void importCountries(Set<Country> countries);

    Country getCountryByCode(String countryCode);
}
