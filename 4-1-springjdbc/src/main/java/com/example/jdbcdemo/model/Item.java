package com.example.jdbcdemo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item {
    private Long id;
    private String name;
    private int price;

}
