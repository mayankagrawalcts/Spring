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

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
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

    //@Column(nullable = false, unique = true)
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

}