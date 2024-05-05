package dannelysbeth.ecommerce.mongodbshop.repository;

import dannelysbeth.ecommerce.mongodbshop.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends MongoRepository<Country, String> {

    Optional<Country> getCountryByCountryIgnoreCase(String country);
}
