package com.example.product_managerment;

import com.example.product_managerment.handler.ProductExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProductExceptionHandler productExceptionHandler(){
        return new ProductExceptionHandler();
    }
}
