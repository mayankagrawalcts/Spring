package com.example.springjpahello.repo;

import com.example.springjpahello.entity.Passport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class GenericRepository {
@Autowired
    EntityManager em;
    public void save(Object p){
        em.persist(p);
    }

}
