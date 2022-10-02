package com.example.final_exam_prepare.service;

import com.example.final_exam_prepare.model.Category;
import com.example.final_exam_prepare.repository.ICategoryRepository;
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
