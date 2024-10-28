package com.giray.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "products")
public class Product extends BaseEntity {


    private String id;
    private String name;
    private double price;
    private int stock;
}
