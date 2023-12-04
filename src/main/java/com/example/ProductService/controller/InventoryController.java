package com.example.ProductService.controller;

import com.example.ProductService.dto.InventoryDto;
import com.example.ProductService.dto.UpdateInventoryDto;
import com.example.ProductService.entity.Inventory;
import com.example.ProductService.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable String id) {
        return inventoryService.getInventoryById(id).orElse(null);
    }

    @GetMapping("/merchant/{merchantId}")
    public Inventory getInventoryByMerchantId(@PathVariable String merchantId) {
        return inventoryService.getInventoryByMerchantId(merchantId).orElse(null);
    }

    @GetMapping("/product/{productId}")
    public Inventory getInventoryByProductId(@PathVariable String productId) {
        return inventoryService.getInventoryByProductId(productId).orElse(null);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @PostMapping
    public boolean addInventory(@RequestBody InventoryDto inventoryDto) {
        return inventoryService.addInventory(inventoryDto);
    }

//    @PutMapping("/{id}")
//    public void updateInventory(@PathVariable String id, @RequestBody Inventory updatedInventory) {
//        inventoryService.updateInventory(id, updatedInventory);
//    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable String id) {

        inventoryService.deleteInventory(id);
    }

    @GetMapping("/name/{name}")
    public List<Inventory> findByName(@PathVariable String name){

        return inventoryService.findByName(name);
    }

    @PutMapping("/update/{merchantId}/{productId}")
    public boolean updateByMerchantAndProduct(@PathVariable String merchantId,String productId,@RequestBody UpdateInventoryDto updatedInventory){

        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(updatedInventory,inventory);
        inventory.setMerchantId(merchantId);
        inventory.setProductId(productId);
        try{
                inventoryService.updateInventory(merchantId,productId,inventory);
                return true;

        }catch (Exception e){
                e.getStackTrace();
                return false;
        }
    }
    }


