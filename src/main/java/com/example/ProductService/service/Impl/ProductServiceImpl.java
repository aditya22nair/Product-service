package com.example.ProductService.service.Impl;
import com.example.ProductService.customExceptions.ProductUpdateException;
import com.example.ProductService.dto.InventoryDto;
import com.example.ProductService.dto.ProductDto;
import com.example.ProductService.entity.Inventory;
import com.example.ProductService.entity.Product;
import com.example.ProductService.repository.InventoryRepository;
import com.example.ProductService.repository.ProductRepository;
import com.example.ProductService.service.InventoryService;
import com.example.ProductService.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private InventoryRepository inventoryRepository;

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


//    public List<ProductDto> getProductsByIds(List<String> productIds) {
//        return productRepository.findProductDtosByIds(productIds);
//    }


//    public void addOrUpdateProduct(ProductDto productDto, String merchantId) {
//        Optional<Inventory> existingInventory = inventoryService.getInventoryByMerchantAndProduct(merchantId, productDto.getProductId());
//
//        if (existingInventory.isPresent()) {
//            updateProductIfPriceLower(productDto, existingInventory.get());
//        } else {
//            addProductAndInventory(productDto, merchantId);
//        }
//    }
//
//    private void addProductAndInventory(ProductDto productDto, String merchantId) {
//        Product product = new Product();
//        BeanUtils.copyProperties(productDto, product);
//        productRepository.save(product);
//
//        InventoryDto inventoryDto = new InventoryDto();
//        inventoryDto.setMerchantId(merchantId);
//        inventoryDto.setProductId(product.getProductId());
//        inventoryDto.setStock(productDto.getStock());
//        inventoryDto.setPrice(productDto.getPrice());
//        inventoryDto.setAvailable(true);
//
//        inventoryService.addOrUpdateInventory(inventoryDto);
//    }
//
//    private void updateProductIfPriceLower(ProductDto productDto, Inventory existingInventory) {
//        if (productDto.getPrice() < existingInventory.getPrice()) {
//            Product product = productRepository.findById(productDto.getProductId()).orElse(null);
//            if (product != null) {
//                // Update product details
//                product.setPrice(productDto.getPrice());
//                productRepository.save(product);
//
//                // Update inventory details
//                existingInventory.setStock(productDto.getStock());
//                existingInventory.setPrice(productDto.getPrice());
//                existingInventory.setAvailable(true);
//                inventoryService.addOrUpdateInventory(existingInventory);
//            }
//        } else {
//            existingInventory.setStock(productDto.getStock());
//            inventoryService.addOrUpdateInventory(existingInventory);
//        }
//    }



    public void updateProduct(String productId, Product updatedProduct) {
        if (productRepository.existsById(productId)) {
            updatedProduct.setProductId(productId);
            productRepository.save(updatedProduct);
        }
    }

    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }
}


