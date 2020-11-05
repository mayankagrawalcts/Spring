package com.example.springjpahello.repo;
import com.example.springjpahello.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface Itemrepository extends JpaRepository<Item, Long> {

    Item findDistinctFirstByName( String name);
    List<Item> findTop5ByName(String name);

    @Procedure(procedureName = "findItemById")
   String ITEMPROCEDURE(@Param("id") int id);

    @Query(value = "CALL findItemById(:id);", nativeQuery = true)
    Item callProcById(@Param("id") Long id);
}
