package dannelysbeth.ecommerce.mongodbshop.mapper.definition;

import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.CartItem;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.ProductItemFullInfo;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.CartResponse;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CartMapper {

    ProductItemFullInfo getProductInfo(ProductItem productItem, Cart cart);

    CartItem getCartItemFromProductItem(ProductItemFullInfo itemFullInfo, Cart cart);

    CartResponse transformToCartResponse(Cart cart);
}
