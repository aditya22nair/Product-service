package com.example.ProductService.service.Impl;


import com.example.ProductService.dto.InventoryDto;
import com.example.ProductService.entity.Inventory;
//import com.example.ProductService.entity.Product;
import com.example.ProductService.repository.InventoryCustomRepository;
import com.example.ProductService.repository.InventoryRepository;
import com.example.ProductService.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryCustomRepository inventoryCustomRepository;

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Optional<Inventory> getInventoryById(String inventoryId) {
        return inventoryRepository.findById(inventoryId);
    }

    @Override
    public Optional<Inventory> getInventoryByMerchantId(String merchantId) {
        return inventoryRepository.findById(merchantId);
    }


    @Override
    public boolean addInventory(InventoryDto inventoryDto) {
        Inventory inventory=new Inventory();
        BeanUtils.copyProperties(inventoryDto,inventory);
        inventory.setInventoryId(UUID.randomUUID().toString());
        Inventory savedInventory = inventoryRepository.save(inventory);
        return Objects.nonNull(savedInventory);

    }


//    @Override
//    public void updateInventory(String inventoryId, Inventory updatedInventory) {
//        Optional<Inventory> existingInventory = inventoryRepository.findById(inventoryId);
//
//        existingInventory.ifPresent(inventory -> {
//            inventory.setStock(updatedInventory.getStock());
//            inventory.setPrice(updatedInventory.getPrice());
//            inventory.setAvailable(updatedInventory.isAvailable());
//            inventoryRepository.save(inventory);
//        });
//    }

    @Override
    public void updateInventory(String merchantId, String productId, Inventory updatedInventory) {
        inventoryCustomRepository.updateInventory(merchantId,productId,updatedInventory);
    }

    @Override
    public void deleteInventory(String inventoryId) {
        inventoryRepository.deleteById(inventoryId);
    }

    @Override
    public List<Inventory> findByName(String name) {
        return inventoryRepository.findByName(name);
    }
}

