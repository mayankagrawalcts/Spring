package com.example.springjpahello.repo;

import com.example.springjpahello.entity.Passport;
import com.example.springjpahello.entity.Student;
import com.example.springjpahello.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Studentrepository extends CrudRepository<Student, Long> {

    @Query("SELECT s.creationTime from Student s JOIN s.courses c where c.name=:courseName")
    List<Student> getStudents(String courseName);

    @Query("SELECT s from Student s JOIN s.passport p where p.passportNumber=:passportNumber")
    List<Student> getStudentsByPassport(String passportNumber);

    @Query("SELECT s FROM Student s JOIN FETCH s.courses")
    List<Student> fetchAllDetails();
    @Query("SELECT p from Passport p where p.passportNumber=:passportNumber")
    Passport getPassportByPassportNumber(String passportNumber);
    @Query("SELECT p from Passport p")
    List<Passport> getPassports();
}
