package com.example.ProductService.repository;

import com.example.ProductService.dto.UpdateInventoryDto;
import com.example.ProductService.entity.Inventory;

public interface InventoryCustomRepository {
    void updateInventory(String merchantId, String productId,Inventory updatedInventory);
}
