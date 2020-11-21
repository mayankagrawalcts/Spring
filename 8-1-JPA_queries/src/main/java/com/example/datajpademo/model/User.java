package com.example.datajpademo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@ToString
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "age")

    private int age;

    @Column(name = "email_address",unique = true)
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    public User() {
    }

    public User(Long id, String firstname, String lastname, int age, String emailAddress, User manager) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.emailAddress = emailAddress;
        this.manager = manager;
    }
}
