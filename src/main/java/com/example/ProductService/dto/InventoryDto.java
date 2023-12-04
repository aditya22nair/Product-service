package com.example.ProductService.dto;

import lombok.Data;

@Data
public class InventoryDto {
    private String productId;
    private String name;
    private String merchantId;
    private int stock;
    private double price;
    private boolean isAvailable;
}
