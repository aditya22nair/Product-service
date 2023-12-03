package com.example.ProductService.repository;
import com.example.ProductService.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

    public interface ProductRepository extends MongoRepository<Product, String> {

    }

