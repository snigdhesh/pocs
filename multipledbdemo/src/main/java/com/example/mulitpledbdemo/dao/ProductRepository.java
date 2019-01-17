package com.example.mulitpledbdemo.dao;

import com.example.mulitpledbdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}