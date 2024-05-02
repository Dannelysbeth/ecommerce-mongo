package dannelysbeth.ecommerce.mongodbshop.repository;

import dannelysbeth.ecommerce.mongodbshop.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>
//        , QuerydslPredicateExecutor<ProductItem>
{
    Product getById(String id);

    Product getByItems_SKU(String SKU);


}
