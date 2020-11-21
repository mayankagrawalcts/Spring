package com.example.springjpahello.repo;

import com.example.springjpahello.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Repository
@Transactional

public class ItemRepositoryImpl {
    @Autowired
    EntityManager em;

    public void callProc() {
        StoredProcedureQuery proc = em.createNamedStoredProcedureQuery("Item.TESTIN");
        try {
            proc.setParameter("name_in", "updated item");
            proc.execute();
            System.out.println("data received: " + proc.getOutputParameterValue("name_out"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
       StoredProcedureQuery proc1 = em.createNamedStoredProcedureQuery("Item.TESTIN1");

            proc1.setParameter("name_in", "updated item");
            proc1.execute();
            System.out.println("data received 2: " + proc1.getOutputParameterValue("price_out"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            StoredProcedureQuery proc2 = em.createStoredProcedureQuery("TESTIN2", Item.class);
            proc2.registerStoredProcedureParameter("item_out", void.class, ParameterMode.REF_CURSOR);
            proc2.registerStoredProcedureParameter("name_in",String.class, ParameterMode.IN);
            proc2.setParameter("name_in", "updated item");
            proc2.execute();
            List<Item> resultList = proc2.getResultList();
            System.out.println("data received 3: " + resultList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            StoredProcedureQuery proc3 = em.createNamedStoredProcedureQuery("Item.TESTIN2");
            proc3.setParameter("name_in", "updated item");
            proc3.execute();
            List<Item> resultList = proc3.getResultList();
            System.out.println("data received 4: " + resultList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
