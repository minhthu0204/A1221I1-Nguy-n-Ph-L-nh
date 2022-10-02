package com.example.product_managerment_3.service;

import com.example.product_managerment_3.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}