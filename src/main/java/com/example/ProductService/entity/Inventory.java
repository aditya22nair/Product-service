package com.example.ProductService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private String inventoryId;
    private String name;
    private String productId;
    private String merchantId;
    private int stock;
    private double price;
    private boolean isAvailable;



}
