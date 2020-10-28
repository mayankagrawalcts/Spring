package com.example.springjdbctemplate.repositories;

import com.example.springjdbctemplate.model.Items;

import java.util.List;

public interface IItemRepo {

    void saveItems(Items items);
    void saveItemsByManual(Items items);
    List<Items> findItemsByName(String name);

    List<Items> findAll();
}
