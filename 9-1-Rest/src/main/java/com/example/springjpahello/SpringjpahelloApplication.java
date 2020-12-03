package com.example.springjpahello;

import com.example.springjpahello.entity.Passport;
import com.example.springjpahello.service.DemoService;
import com.example.springjpahello.service.UserService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringjpahelloApplication {

    public static void main(String[] args) {
       ApplicationContext context= SpringApplication.run(SpringjpahelloApplication.class, args);
       DemoService demoService=context.getBean(DemoService.class);
        RestTemplate restTemplate=context.getBean(RestTemplate.class);

        ParameterizedTypeReference<List<Passport>> typeReference=new ParameterizedTypeReference<List<Passport>>() {
        };
        ResponseEntity<Passport> p=restTemplate.getForEntity("http://localhost:8083/api/demo/passport/E123456",Passport.class);
        System.out.println(p.getBody());

      //  ResponseEntity<List<Passport>> p1=restTemplate.exchange("http://localhost:8083/api/demo/passport", HttpMethod.GET, null, typeReference);
        //System.out.println(p1.getBody());
      // demoService.provideService();
       // demoService.employeeService();
     //  demoService.findDistinctByIdEndingWith2AndName();
  //      demoService.userService();
//demoService.employeeService();
    //    UserService userService=context.getBean(UserService.class);
  //      userService.process();
    }

}
