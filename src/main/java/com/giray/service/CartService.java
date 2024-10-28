package com.giray.service;

import com.giray.entity.Cart;
import com.giray.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {


    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // M��teri kimli�ine g�re sepeti almak i�in metod
    public Cart getCart(String customerId) {
        return cartRepository.findByCustomerId(customerId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(customerId);
                    return cartRepository.save(newCart); // Yeni sepeti veritaban�na kaydet
                });

    }
}