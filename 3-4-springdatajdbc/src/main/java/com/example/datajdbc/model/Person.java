package com.example.datajdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
public class Person {

    @Id
    private long id;
    private String firstName;
    private String lastName;
}
