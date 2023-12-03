package com.example.ProductService.repository.Impl;

import com.example.ProductService.dto.UpdateInventoryDto;
import com.example.ProductService.entity.Inventory;
import com.example.ProductService.repository.InventoryCustomRepository;
import com.example.ProductService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class InventoryCustomRepositoryImpl implements InventoryCustomRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private InventoryRepository inventoryRepository;

    public void updateInventory(String merchantId, String productId, Inventory updatedInventory) {
        Query query = new Query(Criteria.where("merchantId").is(merchantId).and("productId").is(productId));

        Update update = new Update()
                .set("stock", updatedInventory.getStock())
                .set("price", updatedInventory.getPrice());

        mongoTemplate.updateFirst(query, update, Inventory.class);
    }
    }



