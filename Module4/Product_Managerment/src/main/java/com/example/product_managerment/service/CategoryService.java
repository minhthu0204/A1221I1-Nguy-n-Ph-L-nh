package com.example.product_managerment.service;

import com.example.product_managerment.model.Category;
import com.example.product_managerment.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements  ICategoryService{

    @Autowired
    ICategoryRepository categoryRepository;


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
