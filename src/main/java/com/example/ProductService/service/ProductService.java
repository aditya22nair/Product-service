package com.example.ProductService.service;

import com.example.ProductService.dto.ProductDto;
import com.example.ProductService.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String productId);
    boolean addProduct(ProductDto productDto);
    //void updateProduct(String productId, Product updatedProduct);
    void deleteProduct(String productId);
}
