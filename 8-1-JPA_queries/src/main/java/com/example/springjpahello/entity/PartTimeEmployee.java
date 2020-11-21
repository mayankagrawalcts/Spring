package com.example.springjpahello.entity;

import lombok.Data;

import java.math.BigDecimal;

import javax.persistence.Entity;
@Data
@Entity
public class PartTimeEmployee extends Employee {

	protected PartTimeEmployee() {
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	private BigDecimal hourlyWage;

}
