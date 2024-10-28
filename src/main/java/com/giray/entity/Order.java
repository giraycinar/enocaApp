package com.giray.entity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "orders")
public class Order extends BaseEntity {

    private String customerId;
    private List<Product> products;
    private List<CartItem> items;
    private double totalPrice;
    private LocalDateTime orderDate;



}
