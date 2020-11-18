package com.example.springjpahello.service;

import com.example.springjpahello.entity.*;
import com.example.springjpahello.model.Item;
import com.example.springjpahello.model.Person;
import com.example.springjpahello.repo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.*;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    ItemRepositoryImpl itemRepositoryImpl;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    Itemrepository itemrepository;

    @Autowired
    Studentrepository studentrepository;
    @Autowired
    GenericRepository genericRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @PersistenceContext
    EntityManager em;

    @Autowired
    UserRepositoryExtra userRepositoryExtra;

    @Transactional
    public void employeeService() {
        Employee e=new PartTimeEmployee("Mayank",new BigDecimal(12.3));
        Employee e1=new FullTimeEmployee("Mayank",new BigDecimal(12333.3));
        Employee e2=new FullTimeEmployee("Mayank saved",new BigDecimal(12333.3));
        employeeRepository.save(e);
        employeeRepository.save(e1);
        employeeRepository.save(e2);

        System.out.println("find 1 element: "+em.find(PartTimeEmployee.class,e.getId()));
        System.out.println("find by hard code Id element: "+em.find(FullTimeEmployee.class,e1.getId()));
        /*
        System.out.println("find all element: "+employeeRepository.findAll());
        employeeRepository.delete(e);
        employeeRepository.deleteById(e1.getId());
        employeeRepository.findById(124234L).ifPresentOrElse(employeeRepository::delete,() ->{System.out.println("not found");});
           */
        em.remove((PartTimeEmployee)e);
    Optional<FullTimeEmployee> op=   Optional.of( em.find(FullTimeEmployee.class,e1.getId()));
    op.ifPresentOrElse(employeeRepository::delete,() ->{System.out.println("not found");});
    }
        @Transactional
    public void provideService() {
        Person person = new Person();
        person.setLastName("Mayank");
        person.setFirstName("Agrawal");
        Item item = new Item();
        item.setId(2);
        item.setName("updated item");
        item.setName_out("returned item");
        item.setPrice(111);
        itemrepository.save(item);
        personRepository.save(person);
        System.out.println("saved successfully");
        Student student = new Student();
        //System.out.println("callProcById: "+itemrepository.callProcById("updated item"));
        //System.out.println("ITEMPROCEDURE: "+itemrepository.ITEMPROCEDURE("updated item"));
        //itemRepositoryImpl.callProc();
        student.setName("updated Name");
        Address address=Address.builder().city("agra").line1("123").line2("345").build();
        student.setAddress(address);
        Passport passport=new Passport();
        passport.setPassportNumber("123");
        student.setPassport(passport);
        Student student1=studentrepository.findById(19L).orElse(new Student());
        student1.setName("Updated");
        //studentrepository.save(student1);
        //studentrepository.save(student);
        genericRepository.save(passport);
    genericRepository.save(student);
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
    public void findDistinctByIdEndingWith2AndName() {
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
        Item i = itemrepository.findDistinctFirstByName("mayank");
        System.out.println(itemrepository.findTop5ByName("mayank"));
        System.out.println(i);
        //itemRepositoryImpl.callProc();
        }

    @Transactional
    public void userService() {
        Address address=new Address("line1","line2","Agra");
        Set<String> attributes= new HashSet<>();
        attributes.add("a1");attributes.add("a2");attributes.add("a3");attributes.add("a4");
        User u=User.builder().address(address).age(123).binaryData("Password".getBytes()).build();
        Map<String,User> attributesMap=new HashMap<>();
        attributesMap.put("map1",u);
        User u1=User.builder().address(address).attributes(attributes).manager(u).attributesMap(attributesMap).build();
        Set<User> users=new HashSet<>();
        users.add(u);users.add(u1);
        User u2=User.builder().address(address).attributes(attributes).manager(u1).colleagues(users).build();
    userRepositoryExtra.save(u);
        userRepositoryExtra.save(u1);
        userRepositoryExtra.save(u2);
    }
    }
