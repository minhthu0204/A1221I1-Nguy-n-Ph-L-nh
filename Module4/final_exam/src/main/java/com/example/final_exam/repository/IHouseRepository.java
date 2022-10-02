package com.example.final_exam.repository;

import com.example.final_exam.model.Contract;
import com.example.final_exam.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHouseRepository extends JpaRepository<House, Integer> {

}
