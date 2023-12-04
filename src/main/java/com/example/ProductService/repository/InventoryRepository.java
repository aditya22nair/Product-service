package com.example.ProductService.repository;

import com.example.ProductService.entity.Inventory;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, String> {

    List<Inventory> findByName(String name);


    Optional<Inventory> findByMerchantIdAndProductId(String merchantId, String productId);

    Optional<Inventory> findByProductId(String productId);

    Optional<Inventory> findByMerchantId(String merchantId);


}
