package com.example.blog.service;

import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(int id);

    void save( Blog blog);

    void remove(int id);

    Page<Blog> findAllByNameContaining(String name , Pageable pageable);
}
