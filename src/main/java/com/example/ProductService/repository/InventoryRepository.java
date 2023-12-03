package com.example.ProductService.repository;

import com.example.ProductService.entity.Inventory;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findByName(String name);


}
