package com.example.product_managerment.service;

import com.example.product_managerment.model.Product;
import com.example.product_managerment.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Product product) {
        productRepository.save( product);
    }

    @Override
    public void remove(int id) {
    productRepository.deleteById(id);
    }
}
