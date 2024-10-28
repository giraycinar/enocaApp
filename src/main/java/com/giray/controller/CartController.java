package com.giray.controller;

import com.giray.entity.Cart;
import com.giray.service.CartService;
import org.springframework.web.bind.annotation.*;

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




}