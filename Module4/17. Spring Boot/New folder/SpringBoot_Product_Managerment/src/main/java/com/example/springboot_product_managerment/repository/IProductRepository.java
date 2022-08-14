package com.example.springboot_product_managerment.repository;

import com.example.springboot_product_managerment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Integer> {
}
