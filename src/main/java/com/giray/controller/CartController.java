package com.giray.controller;
import com.giray.entity.Cart;
import com.giray.entity.CartItem;
import com.giray.entity.Order;
import com.giray.service.CartService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.giray.constants.RestApiUrls.CART;

@RestController
@RequestMapping(CART)
public class CartController {

    private final CartService cartService;
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{customerId}")
    public Cart getCartByCustomerId(@PathVariable("customerId") String customerId) {
        return cartService.getCart(customerId);
    }
    @PostMapping("/addProduct")
    public Cart addProductToCart(
            @RequestParam("customerId") String customerId,
            @RequestParam("productId") String productId,
            @RequestParam("quantity") int quantity
    ) {
        return cartService.addProductToCart(customerId, productId, quantity);
    }

    @DeleteMapping("/{customerId}/remove/{productId}")
    public Cart removeProductFromCart(@PathVariable("customerId") String customerId, @PathVariable("productId") String productId) {
        return cartService.removeProductFromCart(customerId, productId);
    }
    @PutMapping("/{customerId}")
    public Cart updateCart(@PathVariable("customerId") String customerId, @RequestBody List<CartItem> updatedItems) {
        return cartService.updateCart(customerId, updatedItems);
    }



    @DeleteMapping("/{customerId}")
    public Cart emptyCart(@PathVariable("customerId") String customerId) {
        return cartService.emptyCart(customerId);
    }

    @PostMapping("/order/{customerId}")
    public Order placeOrder(@PathVariable("customerId") String customerId) {
        return cartService.placeOrder(customerId);
    }
}