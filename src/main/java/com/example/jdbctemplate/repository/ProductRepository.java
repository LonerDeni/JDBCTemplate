package com.example.jdbctemplate.repository;

import com.example.jdbctemplate.model.Product;
import com.example.jdbctemplate.model.ProductTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductTypeRequest getProductName(String name) {
        var nameClient = new HashMap<String, String>();
        nameClient.put("name", name);
        var result = namedParameterJdbcTemplate.query(read("search.sql"), nameClient, (rs, rowNum) -> {
            var productName = rs.getString("product_name");
            return new Product(productName);
        });
        return new ProductTypeRequest(result);
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}