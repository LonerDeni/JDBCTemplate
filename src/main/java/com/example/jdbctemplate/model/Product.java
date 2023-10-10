package com.example.jdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private final String productName;



    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + productName + '\'' +
                '}';
    }
}