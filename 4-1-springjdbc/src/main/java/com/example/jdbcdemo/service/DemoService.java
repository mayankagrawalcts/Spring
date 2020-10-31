package com.example.jdbcdemo.service;

import com.example.jdbcdemo.repo.Itemrepository;
import com.example.jdbcdemo.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface DemoService {
    public void provideService();
    void transaction3();
}
