package dannelysbeth.ecommerce.mongodbshop.api;

import dannelysbeth.ecommerce.mongodbshop.exception.NotEnoughProductException;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.AddressMapper;
import dannelysbeth.ecommerce.mongodbshop.mapper.definition.OrderMapper;
import dannelysbeth.ecommerce.mongodbshop.model.*;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.request.OrderRequest;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.GlobalResponse;
import dannelysbeth.ecommerce.mongodbshop.model.DTO.response.OrderResponse;
import dannelysbeth.ecommerce.mongodbshop.service.definition.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final UserService userService;
    private final CartService cartService;
    private final OrderService orderService;
    private final ProductService productService;
    private final ShippingMethodService shippingMethodService;

    private final OrderMapper orderMapper;
    private final AddressMapper addressMapper;

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE', 'USER_ROLE')")
    @PostMapping("/create")
    public ResponseEntity<GlobalResponse> createOrder(@RequestBody OrderRequest request) {
        User loggedUser = userService.getLoggedUser();
        Cart cart = cartService.getCartByUser(loggedUser);
        ShippingMethod shippingMethod = shippingMethodService.getShippingMethodByCode(request.getShippingMethod());
        Order order = orderService.createOrder(loggedUser);

        Address shippingAddress = userService.getAddressByUserAndId(loggedUser, request.getAddressId());


        Set<Item> orderItems = new HashSet<>();
        for (Item cartItem : cart.getItems()) {
            ProductItem productItem = productService.getProductItemById(cartItem.getId());
            orderItems.add(orderMapper.getItemFromCart(cartItem, productItem));
        }

        order = orderMapper.updateOrderFromRequest(order, orderItems, addressMapper.transformAddressToDto(shippingAddress), shippingMethod);


        try {
            productService.decreaseProductItems(order);
            orderService.updateOrder(order);
            cartService.emptyCart(cart);
            return ResponseEntity.ok().body(GlobalResponse.builder().entries(Collections.singleton("Order was successfully created")).responseTime(orderService.getRepositoryResponseTime() + "ms").build());

        } catch (NotEnoughProductException ex) {
            orderService.deleteOrder(order);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(GlobalResponse.builder().entries(Collections.singleton("Not enough products in store")).responseTime(orderService.getRepositoryResponseTime() + "ms").build());
        }

    }

    @PreAuthorize("hasAnyAuthority('ADMIN_ROLE', 'USER_ROLE')")
    @GetMapping()
    public ResponseEntity<GlobalResponse> getLoggedUserOrders() {
        User loggedUser = userService.getLoggedUser();

        Set<Order> orders = orderService.getOrdersByUser(loggedUser);

        Set<OrderResponse> orderResponses = orderMapper.transformToOrderResponse(orders);

        return ResponseEntity.ok().body(GlobalResponse.builder().responseTime(orderService.getRepositoryResponseTime() + "ms").entries(Collections.singleton(orderResponses)).count(orderResponses.size()).build());
    }
}
