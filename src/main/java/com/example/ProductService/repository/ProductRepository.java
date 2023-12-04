package com.example.ProductService.repository;
import com.example.ProductService.dto.ProductDto;
import com.example.ProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
//        @Autowired
//        private MongoTemplate mongoTemplate;
//
//        public List<ProductDto> findProductDtosByIds(List<String> productIds) {
//            Query query = new Query(Criteria.where("productId").in(productIds));
//            return mongoTemplate.find(query, ProductDto.class);
//        }

    }

