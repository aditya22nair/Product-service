package com.example.ProductService.entity;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "categories")
public class Category {
        @Id
        private String categoryId;
        private String categoryName;


}
