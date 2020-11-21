package com.example.datajpademo.model;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
public class FulltimeEmployee extends  Employee{
    BigDecimal salary;

    public FulltimeEmployee() {
    }

    public FulltimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }
}
