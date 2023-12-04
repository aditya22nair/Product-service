package com.example.ProductService.entity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

        @Id
        private String productId;
        private String name;
        private double price;
        private String photoUrl;
        private Object description;
        private String merchantId;
        private double rating;
        private String categoryId;
        private String categoryName;


    }

