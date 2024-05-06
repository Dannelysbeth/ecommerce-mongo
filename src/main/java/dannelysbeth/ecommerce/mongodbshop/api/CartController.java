package dannelysbeth.ecommerce.mongodbshop.api;


import dannelysbeth.ecommerce.mongodbshop.mapper.definition.CartMapper;
import dannelysbeth.ecommerce.mongodbshop.model.Cart;
import dannelysbeth.ecommerce.mongodbshop.model.Item;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.ProductItemFullInfo;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.CartResponse;
import dannelysbeth.ecommerce.mongodbshop.model.ProductItem;
import dannelysbeth.ecommerce.mongodbshop.model.User;
import dannelysbeth.ecommerce.mongodbshop.service.definition.CartService;
import dannelysbeth.ecommerce.mongodbshop.service.definition.ProductService;
import dannelysbeth.ecommerce.mongodbshop.service.definition.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

    private final CartMapper cartMapper;

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE', 'USER_ROLE')")
    @PostMapping("/addItem/{id}")
    public ResponseEntity<String> addItemToCart(@PathVariable String id) {
        ProductItem productItem = productService.getProductItemById(id);
        User loggedUser = userService.getLoggedUser();
        Cart myCart = cartService.getCartByUser(loggedUser);

        ProductItemFullInfo itemFullInfo = productService.getFullProductItemInfo(id);
        Item item = cartMapper.getCartItemFromProductItem(itemFullInfo, myCart);


        this.cartService.addItemToCart(myCart, item);
        return ResponseEntity.ok()
                .body("Item was added to cart");
    }

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE', 'USER_ROLE')")
    @GetMapping()
    public ResponseEntity<CartResponse> getMyCart() {
        User loggedUser = userService.getLoggedUser();
        Cart myCart = cartService.getCartByUser(loggedUser);

        CartResponse cartResponse = cartMapper.transformToCartResponse(myCart);
        return ResponseEntity.ok()
                .body(cartResponse);
    }

}
