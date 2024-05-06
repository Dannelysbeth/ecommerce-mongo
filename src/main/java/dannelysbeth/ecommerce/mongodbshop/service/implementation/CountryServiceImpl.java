package dannelysbeth.ecommerce.mongodbshop.service.implementation;

import dannelysbeth.ecommerce.mongodbshop.exception.CountryNotFoundException;
import dannelysbeth.ecommerce.mongodbshop.model.Country;
import dannelysbeth.ecommerce.mongodbshop.repository.CountryRepository;
import dannelysbeth.ecommerce.mongodbshop.service.definition.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repository;

    @Override
    public void importCountries(Set<Country> countries) {
        repository.saveAll(countries);
    }

    @Override
    public Country getCountryByCode(String countryCode) {
        return repository.findById(countryCode).orElseThrow(CountryNotFoundException::new);
    }
}
