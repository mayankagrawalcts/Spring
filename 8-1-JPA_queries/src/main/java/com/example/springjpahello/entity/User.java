package com.example.springjpahello.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@NamedQueries(value={
        @NamedQuery(name = "User.findAllOrderedDescending",
                query = "SELECT c FROM User c ORDER BY c.firstname DESC"),
        @NamedQuery(name = "User.findByFirstNameAndLastName", query = "SELECT a FROM User a WHERE a.firstname = ?1 AND a.lastname = ?2")
})

@NamedNativeQuery(name = "User.findByFirstName", query = "SELECT * FROM user_table WHERE firstname = ?", resultClass = User.class)

        @Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    private int age;
    //private boolean active;

    @Column(name="email_address",nullable = false, unique = true)
    private String emailAddress;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<User> colleagues;

    @ManyToOne
@JoinColumn(name = "manager_eid")
    private User manager;

    @Embedded
    private Address address;

    @Lob
    private byte[] binaryData;

    @ElementCollection
    private Set<String> attributes;

    @ElementCollection
    @CollectionTable(name = "map_attribute",joinColumns = @JoinColumn(name="test_id"))
    private Map<String,User> attributesMap=new HashMap<>();

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @CreationTimestamp
    LocalDateTime creationTime;
    @UpdateTimestamp
    LocalDateTime updationTime;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}