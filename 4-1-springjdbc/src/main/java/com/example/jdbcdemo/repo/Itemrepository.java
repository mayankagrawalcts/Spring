package com.example.jdbcdemo.repo;

import com.example.jdbcdemo.model.Item;

import java.sql.SQLException;
import java.util.List;


public interface Itemrepository {
    void saveItem(Item item) ;
    List<Item> findAll();
}
