package com.giray.entity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "carts")
public class Cart extends BaseEntity {

    private String customerId;
    private List<Product> products;
    private List<CartItem> items = new ArrayList<>();
    private Double totalPrice = 0.0;


    public Cart(String customerId) {
        this.customerId = customerId;
        this.products = new ArrayList<>();
        this.items = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void updateTotalPrice() {
        double totalPrice = 0.0;
        for (CartItem item : items) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        this.totalPrice = totalPrice;
    }
}
