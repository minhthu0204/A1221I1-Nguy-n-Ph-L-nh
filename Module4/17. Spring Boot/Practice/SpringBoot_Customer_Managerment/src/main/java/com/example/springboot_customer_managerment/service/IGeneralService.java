package com.example.springboot_customer_managerment.service;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);

    void save(T t);
    void remove(Long id);

}
