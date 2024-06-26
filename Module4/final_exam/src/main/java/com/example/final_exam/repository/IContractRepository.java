package com.example.final_exam.repository;

import com.example.final_exam.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository  extends JpaRepository<Contract, Integer> {

}
