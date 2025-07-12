package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    // You can add custom queries here later if needed
}
