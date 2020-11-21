package com.example.datajpademo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    Passport passport;
    @ManyToMany
    @JoinTable(name = "ST_COURCE", joinColumns = @JoinColumn(name = "ST_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    List<Course> courses=new ArrayList<>();
    public String toString() {
        return "Student(id=" + this.getId() + ", name=" + this.getName()  + ")";
    }
    public void addCourse(Course c){
        this.courses.add(c);
    }
}
