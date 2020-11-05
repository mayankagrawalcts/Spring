package com.example.springjpahello.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

@Repository
@Transactional
public class ItemRepositoryImpl {
    @Autowired
    EntityManager em;

    public void callProc() {
        StoredProcedureQuery proc = em.createNamedStoredProcedureQuery("findItemById");


        proc.setParameter("id", 1);
        proc.execute();
        System.out.println(proc.getOutputParameterValue("name"));
    }
}
