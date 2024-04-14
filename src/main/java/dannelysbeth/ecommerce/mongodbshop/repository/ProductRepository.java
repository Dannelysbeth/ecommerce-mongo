package dannelysbeth.ecommerce.mongodbshop.repository;

import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<ProductItem, String> {

}
