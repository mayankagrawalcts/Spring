package com.example.datajpademo.model;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private long id;
    private String description;
    @ManyToOne
    Course course;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
