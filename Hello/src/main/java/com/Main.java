package com;

import com.controller.GreetingController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(Main.class);
        GreetingController greetingController=applicationContext.getBean(GreetingController.class);
        System.out.println(greetingController.GetGreeting());
    }
}
