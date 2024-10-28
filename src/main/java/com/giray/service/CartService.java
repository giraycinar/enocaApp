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




    public Cart getCart(String customerId) {
        Optional<Cart> cart = cartRepository.findOptionalByCustomerId(customerId);
        return cartRepository.findOptionalByCustomerId(customerId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(customerId);
                    return cartRepository.save(newCart);
                });

    }

    public Cart addProductToCart(String customerId, String productId, int quantity) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with id: " + productId);
        }

        Product product = productOptional.get();


        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock for product: " + productId);
        }

        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));
        CartItem cartItem = new CartItem(product.getId(), product.getPrice(), quantity);
        cart.getItems().add(cartItem);
        cart.setTotalPrice(cart.getTotalPrice() + product.getPrice() * quantity);

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        cart.updateTotalPrice();
        return cartRepository.save(cart);
    }


    public Cart removeProductFromCart(String customerId, String productId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Cart not found for customer: " + customerId));

        Optional<CartItem> itemToRemove = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();
        if (itemToRemove.isPresent()) {
            CartItem cartItem = itemToRemove.get();
            cart.getItems().remove(cartItem);

            cart.updateTotalPrice();

            return cartRepository.save(cart);
        } else {
            throw new RuntimeException("Product not found in cart with id: " + productId);
        }
    }


    public Cart updateCart(String customerId, List<CartItem> updatedItems) {
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart(customerId));
        cart.getItems().clear();
        double totalPrice = 0.0;
        for (CartItem updatedItem : updatedItems) {
            cart.getItems().add(updatedItem);
            totalPrice += updatedItem.getPrice() * updatedItem.getQuantity();
        }
        cart.setTotalPrice(totalPrice);
        return cartRepository.save(cart);
    }



    public Cart emptyCart(String customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadý!"));


        cart.setItems(new ArrayList<>());
        cart.setTotalPrice(0.0);


        return cartRepository.save(cart);
    }


    public Order placeOrder(String customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new RuntimeException("Sepet bulunamadý!"));


        Order order = Order.builder()
                .customerId(customerId)
                .products(cart.getProducts())
                .totalPrice(cart.getTotalPrice())
                .orderDate(LocalDateTime.now())
                .build();


        orderRepository.save(order);

        emptyCart(customerId);

        return order;
    }



//    public Order placeOrder(String customerId) {
//        Cart cart = cartRepository.findByCustomerId(customerId)
//                .orElseThrow(() -> new RuntimeException("Sepet bulunamadý!"));
//
//
//        Order order = Order.builder()
//                .customerId(customerId)
//                .items(cart.getItems())
//                .totalPrice(cart.getTotalPrice())
//                .orderDate(LocalDateTime.now())
//                .build();
//

//        orderRepository.save(order);
//
//
//        for (CartItem item : cart.getItems()) {
//            Optional<Product> productOptional = productRepository.findById(item.getProductId());
//            if (productOptional.isPresent()) {
//                Product product = productOptional.get();
//                product.setStock(product.getStock() - item.getQuantity());
//                productRepository.save(product);
//            }
//        }
//
//
//        emptyCart(customerId);
//
//        return order;
//    }



}