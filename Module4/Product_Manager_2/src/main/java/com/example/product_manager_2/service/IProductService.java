package com.example.product_manager_2.service;

import com.example.product_manager_2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(int id);

    void save(Product product);

    void remove(int id);

    Page<Product> findAllByNameContaining(String name , Pageable pageable);
}
