package dannelysbeth.ecommerce.mongodbshop.mapper.implementation;

import dannelysbeth.ecommerce.mongodbshop.mapper.definition.CartMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.ProductItemFullInfo;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.CartResponse;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import org.springframework.stereotype.Component;

@Component
public class CartMapperImpl implements CartMapper {
    @Override
    public ProductItemFullInfo getProductInfo(ProductItem productItem, Cart cart) {
        return ProductItemFullInfo.builder()
                .build();
    }

    @Override
    public Item getCartItemFromProductItem(ProductItemFullInfo itemFullInfo, Cart cart) {
        return Item.builder()
                .productCode(itemFullInfo.getProductCode())
                .name(itemFullInfo.getName())
                .category(itemFullInfo.getCategory())
                .id(itemFullInfo.getProductItemCode())
                .sku(itemFullInfo.getSku())
                .features(itemFullInfo.getFeatures())
                .price(itemFullInfo.getPrice())
                .quantity(1)
                .description(itemFullInfo.getDescription())
                .build();
    }

    @Override
    public CartResponse transformToCartResponse(Cart cart) {
        return CartResponse.builder()
                .username(cart.getUser().getUsername())
                .items(cart.getItems())
                .total(cart.getTotal())
                .build();
    }

//    private Set<CartItemResponse> getCartItemResponses(Set<CartItem> cartItems) {
//        return cartItems.stream().map(cartItem ->
//                CartItemResponse.builder()
//                        .name(cartItem.getName())
//                        .featureSet(cartItem.getFeatures())
//                        .price(cartItem.getPrice())
//                        .category(cartItem.getCategory())
//                        .productCode(cartItem.getProductCode())
//                        .quantity(cartItem.getQuantity())
//                        .description(cartItem.getDescription())
//                        .build()
//        ).collect(Collectors.toSet());
//    }
}
