package com.example.datajpademo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Item {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;
    private String mrp;

}
