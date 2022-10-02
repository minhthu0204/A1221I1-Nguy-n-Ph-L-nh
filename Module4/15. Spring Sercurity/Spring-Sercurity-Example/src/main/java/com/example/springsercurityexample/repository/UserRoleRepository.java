package com.example.springsercurityexample.repository;

import com.example.springsercurityexample.entity.AppUser;
import com.example.springsercurityexample.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
