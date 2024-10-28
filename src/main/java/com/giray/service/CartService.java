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



    // M��teri kimli�ine g�re sepeti almak i�in metod
    public Cart getCart(String customerId) {
        Optional<Cart> cart = cartRepository.findOptionalByCustomerId(customerId);
        return cartRepository.findOptionalByCustomerId(customerId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(customerId);
                    return cartRepository.save(newCart); // Yeni sepeti veritaban�na kaydet
                });

    }

    public Cart addProductToCart(String customerId, String productId, int quantity) {
        // �ncelikle �r�n� ProductRepository'den buluyoruz
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + productId);
        }

        Product product = productOptional.get();

        // M��teri ID'sine g�re sepeti bul veya yoksa yeni bir tane olu�tur
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));

        // �r�n� sepete ekliyoruz
        CartItem cartItem = new CartItem(product.getId(), product.getPrice(), quantity);
        cart.getItems().add(cartItem);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);

        // Sepeti kaydediyoruz
        return cartRepository.save(cart);
    }

    public Cart removeProductFromCart(String customerId, String productId) {
        // Sepeti m��teri ID'sine g�re al
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Cart not found for customer: " + customerId));

        // Sepette ��kar�lacak �r�n� bul
        Optional<CartItem> itemToRemove = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

        // �r�n mevcutsa kald�r
        if (itemToRemove.isPresent()) {
            CartItem cartItem = itemToRemove.get();
            cart.getItems().remove(cartItem);

            // Toplam fiyat� g�ncelle
            double updatedTotalPrice = cart.getTotalPrice() - (cartItem.getPrice() * cartItem.getQuantity());
            cart.setTotalPrice(updatedTotalPrice);

            // Sepeti g�ncelleyip kaydet
            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found in cart with id: " + productId);
        }
    }

    // Cart g�ncelleme i�lemi
    public Cart updateCart(String customerId, List<CartItem> updatedItems) {
        // Sepeti m��teri ID'sine g�re bul veya yeni bir tane olu�tur
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));

        // Mevcut toplam fiyat� s�f�rla
        double totalPrice = 0.0;

        // G�ncellenmi� ��eleri i�leyip sepete ekle veya miktarlar�n� g�ncelle
        for (CartItem updatedItem : updatedItems) {
            cart.getItems().removeIf(item -> item.getProductId().equals(updatedItem.getProductId()));
            cart.getItems().add(updatedItem);

            // �r�n�n fiyat�n� ve miktar�n� kullanarak toplam fiyat� g�ncelle
            totalPrice += updatedItem.getPrice() * updatedItem.getQuantity();
        }

        // G�ncellenen toplam fiyat� ayarla
        cart.setTotalPrice(totalPrice);

        // Sepeti kaydedip g�ncellenmi� halini d�nd�r
        return cartRepository.save(cart);
    }

    // Sepeti bo�altma i�lemi
    public Cart emptyCart(String customerId) {
        // M��teri kimli�ine g�re sepete eri�im
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamad�!"));

        // Sepet ��elerini temizle
        cart.setItems(new ArrayList<>()); // Bo� bir liste ile g�ncelle
        cart.setTotalPrice(0.0); // Toplam fiyat� s�f�rla

        // G�ncellenmi� sepeti kaydet
        return cartRepository.save(cart);
    }

    // Sipari� verme i�lemi
    public Order placeOrder(String customerId) {
        // M��teri kimli�ine g�re sepete eri�im
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamad�!"));

        // Yeni bir sipari� olu�turma
        Order order = Order.builder()
                .customerId(customerId)
                .products(cart.getProducts()) // Sepetteki �r�nler
                .items(cart.getItems()) // Sepetteki ��eler
                .totalPrice(cart.getTotalPrice()) // Toplam fiyat
                .orderDate(LocalDateTime.now()) // Sipari� tarihi
                .build();

        // Sipari�i veritaban�na kaydet
        orderRepository.save(order);

        // Sepeti bo�alt
        emptyCart(customerId); // Sepeti bo�altmak i�in metodu �a��r

        return order;
    }

}