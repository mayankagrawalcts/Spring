package com.example.springjpahello.service;

import org.springframework.stereotype.Service;

@Service
public interface DemoService {
    public void provideService();
    void findDistinctByIdEndingWith2AndName();
    void transaction3();
}
