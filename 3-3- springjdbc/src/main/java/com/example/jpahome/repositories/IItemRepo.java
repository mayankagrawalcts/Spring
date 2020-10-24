package com.example.jpahome.repositories;

import com.example.jpahome.model.Items;

import java.util.List;

public interface IItemRepo {
    public void printTable();
    void saveItems(Items items);
    Items findItemsByName(String name);
    List<Items> findAll();
}
