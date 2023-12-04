package com.example.ProductService;

import com.example.ProductService.entity.Category;
import com.example.ProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Category> categories = Arrays.asList(
                new Category("1", "Men"),
                new Category("2", "Women"),
                new Category("3", "Kids"),
                new Category("4", "Smart Watch")
        );

        // Save categories to the database
        categoryRepository.saveAll(categories);
    }
}


