package com.giray.repository;

import com.giray.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    // M��teri ID'sine g�re sipari�leri bulmak i�in metod
    List<Order> findByCustomerId(String customerId);
}
