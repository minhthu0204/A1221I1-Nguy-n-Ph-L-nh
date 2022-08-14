package com.example.hoanthiengiohang.service;

import com.example.hoanthiengiohang.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}