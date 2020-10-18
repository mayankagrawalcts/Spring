package com.service;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

    public String getGreeting(){
        return "Hello";
    }


}
