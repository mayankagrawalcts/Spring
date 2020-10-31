package com.example.jdbcdemo.service;

import com.example.jdbcdemo.exception.DaoException;
import com.example.jdbcdemo.model.Item;
import com.example.jdbcdemo.model.Person;
import com.example.jdbcdemo.repo.Itemrepository;
import com.example.jdbcdemo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    Itemrepository itemrepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = DaoException.class, noRollbackFor = Exception.class)
    public void provideServiceLoop() throws Exception {
        Person person = new Person(new Random().nextInt(1000), "a", "b");
        Item item = new Item();
        item.setId((long) new Random().nextInt(1000));
        item.setName("commit false");
        item.setPrice(111);
        itemrepository.saveItem(item);
        personRepository.savePerson(person);
        System.out.println("saved successfully");
    }

    @Transactional(propagation = Propagation.REQUIRED, noRollbackFor = NullPointerException.class)
    public void provideService() {
        Person person = new Person(new Random().nextInt(1000), "a", "b");
        Item item = new Item();
        item.setId((long) new Random().nextInt(1000));
        item.setName("commit false");
        item.setPrice(111);
        itemrepository.saveItem(item);
        personRepository.savePerson(person);
        System.out.println("saved successfully");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction3() {
        transaction1();
for(int i=0;i<100;i++) {
    transaction2();
}
        //  throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.NESTED)
    public void transaction2() {
        Person person = new Person(new Random().nextInt(1000), "a", "b");
        personRepository.savePerson(person);
        throw new RuntimeException();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction1() {
        Item item = new Item();
        item.setId((long) new Random().nextInt(1000));
        item.setName("commit false");
        item.setPrice(111);
        itemrepository.saveItem(item);
      }
}
