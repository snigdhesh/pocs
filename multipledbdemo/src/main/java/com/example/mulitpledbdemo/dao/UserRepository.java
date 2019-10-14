package com.example.mulitpledbdemo.dao;

import com.example.mulitpledbdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Integer> {
}