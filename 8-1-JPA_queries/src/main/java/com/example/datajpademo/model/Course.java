package com.example.datajpademo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Course {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    List<Review> reviews=new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    List<Student> students=new ArrayList<>();

    public void addStudent(Student s){
        this.getStudents().add(s);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.getReviews().add(review);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
