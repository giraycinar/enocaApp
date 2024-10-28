package com.giray.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer extends BaseEntity {


    private String id;
    private String name;
    private String surname;
    private String email;
    

}
