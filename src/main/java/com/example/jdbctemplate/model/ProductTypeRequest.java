package com.example.jdbctemplate.model;

import com.example.jdbctemplate.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class ProductTypeRequest {
    private List<Product> productList;
}
