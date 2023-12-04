package com.example.ProductService.dto;

import lombok.Data;

@Data
public class UpdateInventoryDto {
    private int stock;
    private double price;
}
