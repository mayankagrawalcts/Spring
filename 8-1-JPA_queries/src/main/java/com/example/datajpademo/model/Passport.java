package com.example.datajpademo.model;

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
    @OneToOne(mappedBy = "passport", fetch = FetchType.LAZY)
    Student student;
}
