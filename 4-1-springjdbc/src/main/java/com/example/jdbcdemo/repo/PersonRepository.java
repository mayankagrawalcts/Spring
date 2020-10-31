package com.example.jdbcdemo.repo;

import com.example.jdbcdemo.model.Person;

import java.util.List;


public interface PersonRepository {
    void savePerson(Person person);
    List<Person> findAll();
  }
