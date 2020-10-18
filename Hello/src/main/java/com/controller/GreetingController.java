package com.controller;

import com.model.Employee;
import com.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {
    //@Autowired
    GreetingService greetingService;
    Employee employee;

    public GreetingController(@Qualifier("consGreetingService")
                                       GreetingService greetingService) {
        this.greetingService = greetingService;
        System.out.println("employee: "+employee);
    }
/*

    @Autowired
    @Qualifier("consGreetingService")
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
*/

    public String GetGreeting() {
        return greetingService.getGreeting();
    }
}
