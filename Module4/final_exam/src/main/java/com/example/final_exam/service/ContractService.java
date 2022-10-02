package com.example.final_exam.service;

import com.example.final_exam.model.Contract;
import com.example.final_exam.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    IContractRepository contractRepository;


    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findById(int id) {
       return null;
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllByNameContaining(String name, Pageable pageable) {
        return null;
    }
}
