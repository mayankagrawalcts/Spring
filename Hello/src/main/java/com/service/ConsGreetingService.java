package com.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
public class ConsGreetingService implements GreetingService {

    @Override
    public String getGreeting() {
        return "ConsGreetingService";
    }
}
