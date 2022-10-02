package com.example.blog.service;

import com.example.blog.model.User;
import com.example.blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserRepository userRepository;

    public UserServiceImpl() {
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    public User findById(int id) {
        return null;
    }
}
