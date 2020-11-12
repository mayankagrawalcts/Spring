package com.example.springjpahello.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;
    private String passportNumber;

}
