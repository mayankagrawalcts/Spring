package com.example.jpahome;

import com.example.jpahome.controllers.IndexController;
import com.example.jpahome.model.Items;
import com.example.jpahome.repositories.IItemRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JpahomeApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(JpahomeApplication.class, args);
        IItemRepo iItemRepo= context.getBean(IItemRepo.class);
        iItemRepo.printTable();
        iItemRepo.saveItems(new Items(1L,"mayank",123));
        System.out.println(iItemRepo.findAll());
        System.out.println(iItemRepo.findItemsByName("a"));
    }

}
