package com.example.datajpademo.repo;

import com.example.datajpademo.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Itemrepository extends CrudRepository<Item, Long> {
}
