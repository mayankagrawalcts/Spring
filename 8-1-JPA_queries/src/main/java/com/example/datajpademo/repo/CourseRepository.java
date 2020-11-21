package com.example.datajpademo.repo;

import com.example.datajpademo.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Long> {
}
