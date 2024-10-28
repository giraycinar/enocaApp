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

    // Müþteri kimliðine göre sepet almak için metod
    @GetMapping("/{customerId}")
    public Cart getCartByCustomerId(@PathVariable("customerId") String customerId) {
        return cartService.getCart(customerId); // CartService'den sepeti al
    }

    @PostMapping("/addProduct")
    public Cart addProductToCart(
            @RequestParam("customerId") String customerId,
            @RequestParam("productId") String productId,
            @RequestParam("quantity") int quantity
    ) {
        return cartService.addProductToCart(customerId, productId, quantity);
    }

    // Sepetten ürün çýkarmak için metod
    //ürün yoksa hata fýrlat
    @DeleteMapping("/{customerId}/remove/{productId}")
    public Cart removeProductFromCart(@PathVariable("customerId") String customerId, @PathVariable("productId") String productId) {
        return cartService.removeProductFromCart(customerId, productId);
    }
    // Sepeti güncellemek için metod
    @PutMapping("/{customerId}")
    public Cart updateCart(@PathVariable("customerId") String customerId, @RequestBody List<CartItem> updatedItems) {
        return cartService.updateCart(customerId, updatedItems);
    }



    // Sepeti boþaltmak için metod
    @DeleteMapping("/{customerId}")
    public Cart emptyCart(@PathVariable("customerId") String customerId) {
        return cartService.emptyCart(customerId);
    }

    // Sipariþ vermek için metod
    @PostMapping("/order/{customerId}")
    public Order placeOrder(@PathVariable("customerId") String customerId) {
        return cartService.placeOrder(customerId);
    }
}