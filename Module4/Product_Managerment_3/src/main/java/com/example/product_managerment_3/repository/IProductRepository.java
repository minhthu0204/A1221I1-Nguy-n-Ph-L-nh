package com.example.product_managerment_3.repository;

import com.example.product_managerment_3.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContaining(String name , Pageable pageable);
}
