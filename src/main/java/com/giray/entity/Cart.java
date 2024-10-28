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


    // Müþteri ID'si ile yeni bir sepet oluþturmak için yapýlandýrýcý
    public Cart(String customerId) {
        this.customerId = customerId;
        this.products = new ArrayList<>(); // Boþ ürün listesi
        this.items = new ArrayList<>(); // Boþ sepet öðeleri
        this.totalPrice = 0.0; // Baþlangýçta toplam fiyat
    }

    // Toplam fiyatý güncelleyen metod
    public void updateTotalPrice() {
        totalPrice = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}
