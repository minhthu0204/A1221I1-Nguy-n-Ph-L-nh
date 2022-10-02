package com.example.product_managerment_3.service;

import com.example.product_managerment_3.model.Category;
import com.example.product_managerment_3.repository.ICategoryRepository;
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
