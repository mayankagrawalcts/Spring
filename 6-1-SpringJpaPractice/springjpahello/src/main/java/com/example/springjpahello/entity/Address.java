package com.example.springjpahello.entity;

import lombok.Builder;

import javax.persistence.Embeddable;

@Embeddable
@Builder
public class Address {
	protected Address() {}
	
	public Address(String line1, String line2, String city) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
	}

	private String line1;
	private String line2;
	private String city;

	
}