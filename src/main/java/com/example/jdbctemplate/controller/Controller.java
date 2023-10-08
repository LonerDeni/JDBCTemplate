package com.example.jdbctemplate.controller;

import com.example.jdbctemplate.repository.ProductRepository;
import com.example.jdbctemplate.model.ProductTypeRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    ProductRepository productRepository;

    public Controller(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products/fetch-product")
    public ProductTypeRequest getProduct(@RequestParam @RequestBody String name) {
        return productRepository.getProductName(name);
    }
}