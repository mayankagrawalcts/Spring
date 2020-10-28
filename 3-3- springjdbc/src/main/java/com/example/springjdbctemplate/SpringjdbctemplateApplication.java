package com.example.springjdbctemplate;

import com.example.springjdbctemplate.model.Items;
import com.example.springjdbctemplate.repositories.IItemRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Random;

@SpringBootApplication
public class SpringjdbctemplateApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringjdbctemplateApplication.class, args);
        IItemRepo iItemRepo = context.getBean(IItemRepo.class);
        iItemRepo.saveItems(new Items((long)(new Random().nextInt(1000)), "a", 123));
        iItemRepo.saveItems(new Items((long)(new Random().nextInt(1000)), "mayank", 123));
        iItemRepo.saveItemsByManual(new Items((long)(new Random().nextInt(1000)), "mayankManual", 123));
        System.out.println(iItemRepo.findAll());
        System.out.println(iItemRepo.findItemsByName("mayankManual"));
    }
}
