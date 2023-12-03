package com.example.ProductService.controller;
import com.example.ProductService.dto.ProductDto;
import com.example.ProductService.entity.Product;
import com.example.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/products")
public class ProductController {
        @Autowired
        private ProductService productService;

        @GetMapping
        public List<Product> getAllProducts() {
            return productService.getAllProducts();
        }

        @GetMapping("/{productId}")
        public Product getProductById(@PathVariable String productId) {
            return productService.getProductById(productId);
        }

        @PostMapping
        public boolean addProduct(@RequestBody ProductDto productDto) {
            return productService.addProduct( productDto);
        }

//        @PutMapping("/{productId}")
//        public void updateProduct(@PathVariable String productId, @RequestBody Product updatedProduct) {
//            productService.updateProduct(productId, updatedProduct);
//        }

        @DeleteMapping("/{productId}")
        public void deleteProduct(@PathVariable String productId) {
            productService.deleteProduct(productId);
        }
    }

