package com.example.springjpahello.controller;

import com.example.springjpahello.entity.Passport;
import com.example.springjpahello.repo.Studentrepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PassportControllerTest {
@Autowired
    RestTemplate restTemplate;
    @BeforeEach
    void setUp() {
    }

    @Test
    void retrieveAllUsers() {
       ResponseEntity<Passport> p=restTemplate.getForEntity("http://localhost:8083/api/demo/passport/E123456",Passport.class);
        System.out.println(p.getBody());

        ResponseEntity<Passport[]> p1=restTemplate.getForEntity("http://localhost:8083/api/demo/passport",Passport[].class);
        System.out.println(p1.getBody());
    }

    @Test
    void testRetrieveAllUsers() {
    }
}