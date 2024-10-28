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


    // M��teri ID'si ile yeni bir sepet olu�turmak i�in yap�land�r�c�
    public Cart(String customerId) {
        this.customerId = customerId;
        this.products = new ArrayList<>(); // Bo� �r�n listesi
        this.items = new ArrayList<>(); // Bo� sepet ��eleri
        this.totalPrice = 0.0; // Ba�lang��ta toplam fiyat
    }

    // Toplam fiyat� g�ncelleyen metod
    public void updateTotalPrice() {
        totalPrice = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }
}
