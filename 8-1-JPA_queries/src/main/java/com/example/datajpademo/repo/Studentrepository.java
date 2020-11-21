package com.example.datajpademo.repo;

import com.example.datajpademo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Studentrepository extends CrudRepository<Student, Long> {
}
