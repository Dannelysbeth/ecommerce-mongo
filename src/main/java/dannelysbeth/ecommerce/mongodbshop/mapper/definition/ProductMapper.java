package dannelysbeth.ecommerce.mongodbshop.mapper.definition;

import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.ProductRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.ProductItemResponse;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.ProductResponse;
import dannelysbeth.ecommerce.mongodbshop.model.Product;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductMapper {
//    List<ProductItem> readFromFile(MultipartFile file);

    Set<Product> transformFromRequest(List<ProductRequest> requests);

    Set<ProductItemResponse> transformToProductItemResponse(Set<ProductItem> productItems);

    Set<ProductResponse> transformToProductResponse(Set<Product> products);
}
