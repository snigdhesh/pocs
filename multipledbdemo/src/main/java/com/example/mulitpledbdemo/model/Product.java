package com.example.mulitpledbdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(schema = "spring_jpa_product")
@Table
public class Product {

    @Id
    private int id;

    private String name;

    private double price;
}
