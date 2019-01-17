package com.example.mulitpledbdemo.repository;

import com.example.mulitpledbdemo.model.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;


@Repository
@Transactional("mysqlTx")
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Iterable<Customer> findAll();
}
