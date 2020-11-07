package com.example.springjpahello.repo;

import com.example.springjpahello.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Studentrepository extends CrudRepository<Student, Long> {
}
