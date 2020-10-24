package com.example.datajdbc;

import com.example.datajdbc.model.Person;
import com.example.datajdbc.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class DatajdbcApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {

        ApplicationContext context=SpringApplication.run(DatajdbcApplication.class, args);
    }

    @Autowired
    private DatabaseSeeder dbSeeder;

    @Override
    public void run(String... arg0) throws Exception {

        log.info("@@ Inserting Data....");
        dbSeeder.insertData();
        log.info("@@ findAll() call...");
        repository.findAll()
                .forEach(person -> log.info(person.toString()));
        log.info("@@ findById() call...");
        Optional<Person> optionalPerson = repository.findById(1L);
        optionalPerson.ifPresent(person -> log.info(person.toString()));
        log.info("@@ save() call...");
        Person newPerson = new Person(1L,"Franz", "Kafka");
        Person result = repository.save(newPerson);
        log.info(result.toString());
        log.info("@@ delete");
        optionalPerson.ifPresent(person -> repository.delete(person));
        log.info("@@ findAll() call...");
        repository.findAll()
                .forEach(person -> log.info(person.toString()));
        log.info("@@ findByFirstName() call...");
        repository.findByFirstName("Franz")
                .forEach(person -> log.info(person.toString()));
        log.info("@@ findByFirstName() call...");
        repository.updateByFirstName(2L, "Date Inferno");
        repository.findAll()
                .forEach(person -> log.info(person.toString()));

    }
}
