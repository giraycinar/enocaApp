package com.giray.service;

import com.giray.entity.Cart;
import com.giray.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {


    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // M��teri kimli�ine g�re sepeti almak i�in metod
    public Cart getCart(String customerId) {
        Optional<Cart> cart = cartRepository.findOptionalByCustomerId(customerId);
        return cartRepository.findOptionalByCustomerId(customerId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(customerId);
                    return cartRepository.save(newCart); // Yeni sepeti veritaban�na kaydet
                });

    }
}