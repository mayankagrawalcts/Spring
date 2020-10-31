package com.example.jdbcdemo;

import com.example.jdbcdemo.exception.DaoException;
import com.example.jdbcdemo.model.Item;
import com.example.jdbcdemo.model.Person;
import com.example.jdbcdemo.repo.Itemrepository;
import com.example.jdbcdemo.repo.PersonRepository;
import com.example.jdbcdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class JdbcdemoApplication  {
@Autowired
    DemoService demoService;
@Autowired
Itemrepository item;

public static void main(String[] args) {

        ApplicationContext context=SpringApplication.run(JdbcdemoApplication.class, args);
        Itemrepository repo=context.getBean(Itemrepository.class);
      Item item=new Item();
      item.setId(7L);
        item.setName("commit false");
        item.setPrice(111);
        repo.saveItem(item);
        System.out.println(repo.findAll());

    }


}
