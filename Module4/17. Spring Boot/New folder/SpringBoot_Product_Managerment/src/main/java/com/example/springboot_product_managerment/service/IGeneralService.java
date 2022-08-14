package com.example.springboot_product_managerment.service;

import com.example.springboot_product_managerment.model.Product;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(int id);

    void save(Product product);

    void remove(int id);


}
