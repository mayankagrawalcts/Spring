package com.example.springjpahello;

import com.example.springjpahello.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpahelloApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(SpringjpahelloApplication.class, args);
       DemoService demoService=context.getBean(DemoService.class);
     //  demoService.provideService();
       demoService.findDistinctByIdEndingWith2AndName();

    }
}
