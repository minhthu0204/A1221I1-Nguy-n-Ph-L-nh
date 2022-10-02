package com.example.final_exam.service;

import com.example.final_exam.model.House;
import com.example.final_exam.repository.IHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService  implements IHouseService{
    @Autowired
    IHouseRepository houseRepository;


    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }
}
