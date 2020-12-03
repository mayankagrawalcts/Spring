package com.example.springjpahello.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@Entity
@JsonRootName(value = "passport", namespace = "passports")
public class Passport implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "passport_number")
    private String passportNumber;

}
