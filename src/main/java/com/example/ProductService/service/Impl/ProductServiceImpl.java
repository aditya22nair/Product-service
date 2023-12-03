package com.example.ProductService.service.Impl;
import com.example.ProductService.customExceptions.ProductUpdateException;
import com.example.ProductService.dto.InventoryDto;
import com.example.ProductService.dto.ProductDto;
import com.example.ProductService.entity.Product;
import com.example.ProductService.repository.ProductRepository;
import com.example.ProductService.service.InventoryService;
import com.example.ProductService.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryService inventoryService;

    public boolean addProduct(ProductDto productDto) {
        Product product=new Product();
        BeanUtils.copyProperties(productDto,product);
        product.setProductId(UUID.randomUUID().toString());
        Product savedProduct = productRepository.save(product);
        return Objects.nonNull(savedProduct);
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(String productId) {

        Optional<Product> productOptional= productRepository.findById(productId);
        return productOptional.isPresent() ? productOptional.get() : null;

    }




//    public void updateProduct(String productId, Product updatedProduct) {
//        if (productRepository.existsById(productId)) {
//            updatedProduct.setProductId(productId);
//            productRepository.save(updatedProduct);
//        }
//    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}


