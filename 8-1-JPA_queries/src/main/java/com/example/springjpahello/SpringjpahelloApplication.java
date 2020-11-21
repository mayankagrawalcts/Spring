package com.example.springjpahello;

import com.example.springjpahello.service.DemoService;
import com.example.springjpahello.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpahelloApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(SpringjpahelloApplication.class, args);
       DemoService demoService=context.getBean(DemoService.class);
      // demoService.provideService();
       // demoService.employeeService();
     //  demoService.findDistinctByIdEndingWith2AndName();
  //      demoService.userService();
//demoService.employeeService();
        UserService userService=context.getBean(UserService.class);
        userService.process();
    }
}
