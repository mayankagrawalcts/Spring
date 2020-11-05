package com.example.springjpahello.service;

import com.example.springjpahello.model.Item;
import com.example.springjpahello.model.Person;
import com.example.springjpahello.repo.ItemRepositoryImpl;
import com.example.springjpahello.repo.Itemrepository;
import com.example.springjpahello.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class DemoServiceImpl implements DemoService {
@Autowired
    ItemRepositoryImpl itemRepositoryImpl;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    Itemrepository itemrepository;

    @Transactional
    public void provideService() {
        Person person = new Person();
        person.setLastName("Mayank");
        person.setFirstName("Agrawal");
        Item item = new Item();
        item.setName("commit false");
        item.setPrice(111);
        itemrepository.save(item);
        personRepository.save(person);
        System.out.println("saved successfully");
    }


    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction3() {
        transaction1();
        for (int i = 0; i < 100; i++) {
            transaction2();
        }
        //  throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.NESTED)
    public void transaction2() {
        Person person = new Person(new Random().nextInt(1000), "a", "b");
        personRepository.save(person);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction1() {
        Item item = new Item();
        //item.setId((long) new Random().nextInt(1000));
        item.setName("commit false");
        item.setPrice(111);
        itemrepository.save(item);
    }

    @Transactional
    public void findDistinctByIdEndingWith2AndName(){
        Item item = new Item();
        item.setId(12);
        item.setName("mayank");
        item.setPrice(111);
        itemrepository.save(item);
    //    item.setId(14L);
        item.setName("mayank agrawal");

        item.setId(13);
        item.setName("mayank");
        itemrepository.save(item);
        Item i=itemrepository.findDistinctFirstByName("mayank");
        System.out.println(itemrepository.findTop5ByName("mayank"));
        System.out.println(i);
        //itemRepositoryImpl.callProc();
         System.out.println(itemrepository.ITEMPROCEDURE(13));
       // System.out.println(itemrepository.callProcById(13L));
    }
}
