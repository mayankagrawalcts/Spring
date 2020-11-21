package com.example.datajpademo;

import com.example.datajpademo.repo.Itemrepository;
import com.example.datajpademo.service.DemoService;
import com.example.datajpademo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DatajpademoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DatajpademoApplication.class, args);
        DemoService service = context.getBean(DemoService.class);
        UserService userService = context.getBean(UserService.class);
        //service.process();
        //service.CourseProcess();
        //service.CourseStudentProcess();
        //service.EmployeeService();
        //Itemrepository repo = context.getBean(Itemrepository.class);

        //System.out.println(repo.findAll());
        userService.process();
    }

}
