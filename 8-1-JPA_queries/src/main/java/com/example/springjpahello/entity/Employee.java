package com.example.springjpahello.entity;

import lombok.Data;

import javax.persistence.*;

//@MappedSuperclass
@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    protected Employee() {
    }
    protected Employee(String name) {
        this.name=name;
    }

}