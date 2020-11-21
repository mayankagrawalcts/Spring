package com.example.springjpahello.repo;

import com.example.springjpahello.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Itemrepository extends JpaRepository<Item, Long> {

    Item findDistinctFirstByName(String name);

    List<Item> findTop5ByName(String name);


    @Query(value = "select ", nativeQuery = true)
    Integer callProcById(@Param("name_in") String name_in);


}
