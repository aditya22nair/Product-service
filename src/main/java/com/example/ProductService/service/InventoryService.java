package com.example.ProductService.service;

import com.example.ProductService.dto.InventoryDto;
import com.example.ProductService.entity.Inventory;
import com.example.ProductService.entity.Product;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    List<Inventory> getAllInventory();
    boolean addInventory(InventoryDto inventoryDto);
    Optional<Inventory> getInventoryById(String inventoryId);
    Optional<Inventory> getInventoryByMerchantId(String merchantId);
//    void updateInventory(String inventoryId, Inventory updatedInventory);
    void deleteInventory(String inventoryId);

    List<Inventory> findByName(String name);
    void updateInventory(String merchantId, String productId, Inventory updatedInventory);
}
