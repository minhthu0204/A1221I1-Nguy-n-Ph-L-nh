package com.example.final_exam.service;

import com.example.final_exam.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    Optional<Contract> findById(int id);

    void save(Contract contract);

    void remove(int id);

    Page<Contract> findAllByNameContaining(String name , Pageable pageable);
}
