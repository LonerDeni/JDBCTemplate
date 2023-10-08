package com.example.jdbctemplate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
    private final String product_name;



    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +
                '}';
    }
}