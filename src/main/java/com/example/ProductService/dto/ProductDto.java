package com.example.ProductService.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private String name;
    private double price;
    private List<String> photoUrl;
    private Object description;
    private String merchantId;
    private double rating;
    private String categoryId;

}
