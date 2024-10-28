package com.giray.repository;

import com.giray.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CartRepository extends MongoRepository<Cart, String> {


    Optional<Cart> findByCustomerId(String customerId);

}