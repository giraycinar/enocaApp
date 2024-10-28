package com.giray.service;

import com.giray.entity.Cart;
import com.giray.entity.CartItem;
import com.giray.entity.Order;
import com.giray.entity.Product;
import com.giray.repository.CartRepository;
import com.giray.repository.OrderRepository;
import com.giray.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    public CartService(CartRepository cartRepository, ProductRepository productRepository, OrderRepository orderRepository) {


        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }



    // Müþteri kimliðine göre sepeti almak için metod
    public Cart getCart(String customerId) {
        Optional<Cart> cart = cartRepository.findOptionalByCustomerId(customerId);
        return cartRepository.findOptionalByCustomerId(customerId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(customerId);
                    return cartRepository.save(newCart); // Yeni sepeti veritabanýna kaydet
                });

    }

    public Cart addProductToCart(String customerId, String productId, int quantity) {
        // Öncelikle ürünü ProductRepository'den buluyoruz
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + productId);
        }

        Product product = productOptional.get();

        // Müþteri ID'sine göre sepeti bul veya yoksa yeni bir tane oluþtur
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));

        // Ürünü sepete ekliyoruz
        CartItem cartItem = new CartItem(product.getId(), product.getPrice(), quantity);
        cart.getItems().add(cartItem);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);

        // Sepeti kaydediyoruz
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(String customerId, String productId) {
        // Sepeti müþteri ID'sine göre al
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Cart not found for customer: " + customerId));

        // Sepette çýkarýlacak ürünü bul
        Optional<CartItem> itemToRemove = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

        // Ürün mevcutsa kaldýr
        if (itemToRemove.isPresent()) {
            CartItem cartItem = itemToRemove.get();
            cart.getItems().remove(cartItem);

            // Toplam fiyatý güncelle
            double updatedTotalPrice = cart.getTotalPrice() - (cartItem.getPrice() * cartItem.getQuantity());
            cart.setTotalPrice(updatedTotalPrice);

            // Sepeti güncelleyip kaydet
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found in cart with id: " + productId);
        }
    }

    // Cart güncelleme iþlemi
    public Cart updateCart(String customerId, List<CartItem> updatedItems) {
        // Sepeti müþteri ID'sine göre bul veya yeni bir tane oluþtur
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));

        // Mevcut toplam fiyatý sýfýrla
        double totalPrice = 0.0;

        // Güncellenmiþ öðeleri iþleyip sepete ekle veya miktarlarýný güncelle
        for (CartItem updatedItem : updatedItems) {
            cart.getItems().removeIf(item -> item.getProductId().equals(updatedItem.getProductId()));
            cart.getItems().add(updatedItem);

            // Ürünün fiyatýný ve miktarýný kullanarak toplam fiyatý güncelle
            totalPrice += updatedItem.getPrice() * updatedItem.getQuantity();
        }

        // Güncellenen toplam fiyatý ayarla
        cart.setTotalPrice(totalPrice);

        // Sepeti kaydedip güncellenmiþ halini döndür
        return cartRepository.save(cart);
    }

    // Sepeti boþaltma iþlemi
    public Cart emptyCart(String customerId) {
        // Müþteri kimliðine göre sepete eriþim
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadý!"));

        // Sepet öðelerini temizle
        cart.setItems(new ArrayList<>()); // Boþ bir liste ile güncelle
        cart.setTotalPrice(0.0); // Toplam fiyatý sýfýrla

        // Güncellenmiþ sepeti kaydet
        return cartRepository.save(cart);
    }

    // Sipariþ verme iþlemi
    public Order placeOrder(String customerId) {
        // Müþteri kimliðine göre sepete eriþim
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadý!"));

        // Yeni bir sipariþ oluþturma
        Order order = Order.builder()
                .customerId(customerId)
                .products(cart.getProducts()) // Sepetteki ürünler
                .items(cart.getItems()) // Sepetteki öðeler
                .totalPrice(cart.getTotalPrice()) // Toplam fiyat
                .orderDate(LocalDateTime.now()) // Sipariþ tarihi
                .build();

        // Sipariþi veritabanýna kaydet
        orderRepository.save(order);

        // Sepeti boþalt
        emptyCart(customerId); // Sepeti boþaltmak için metodu çaðýr

        return order;
    }

}