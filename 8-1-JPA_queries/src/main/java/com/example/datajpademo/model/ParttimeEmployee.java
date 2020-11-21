package com.example.datajpademo.model;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
public class ParttimeEmployee  extends  Employee{
    BigDecimal hourlyWage;

    public ParttimeEmployee() {
    }

    public ParttimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
