package com.example.mulitpledbdemo.controller;

import com.example.mulitpledbdemo.model.Customer;
import com.example.mulitpledbdemo.repository.CustomerRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(path = "/all")
    public Iterable<Customer> getAllUsers() {
        return customerRepository.findAll();
    }
}
