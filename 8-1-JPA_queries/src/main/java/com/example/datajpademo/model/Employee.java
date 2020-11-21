package com.example.datajpademo.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "employee_type")
public abstract class Employee {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    @CreationTimestamp
    LocalDateTime creationTime;

    @UpdateTimestamp
    LocalDateTime updationTime;

    @Lob
    byte[] data;

    @ElementCollection
    @CollectionTable(name = "employee_address",joinColumns = @JoinColumn(name = "employe_id"))
    private Set<Address> addresses=new HashSet<>();

    @Embedded
    Address address;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }
}
