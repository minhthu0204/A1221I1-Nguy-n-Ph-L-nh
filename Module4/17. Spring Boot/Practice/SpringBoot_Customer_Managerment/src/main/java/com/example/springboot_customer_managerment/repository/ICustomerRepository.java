package com.example.springboot_customer_managerment.repository;

import com.example.springboot_customer_managerment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {

}
