package com.example.springjpahello.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "SD_User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstname;
    private String lastname;
    private int age;
    private boolean active;

    @Column(nullable = false, unique = true)
    private String emailAddress;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> colleagues;

    @ManyToOne
    private User manager;

    @Embedded
    private Address address;

    @Lob
    private byte[] binaryData;

    @ElementCollection
    private Set<String> attributes;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    /**
     * Creates a new empty instance of {@code User}.
     */
    public User() {
    }
}