package com.example.mulitpledbdemo.model;

import javax.persistence.*;

@Entity
@Table(schema = "playground")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;
}