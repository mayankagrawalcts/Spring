package com.example.springjpahello.entity;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
@Data
@Entity
public class FullTimeEmployee extends Employee {
	protected FullTimeEmployee() {
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	private BigDecimal salary;

}
