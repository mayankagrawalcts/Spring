package com.example.datajpademo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Builder
@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String line3;

    public Address() {
    }

    public Address(String line1, String line2, String line3) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
    }
}
