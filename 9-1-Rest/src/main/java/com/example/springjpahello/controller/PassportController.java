package com.example.springjpahello.controller;

import com.example.springjpahello.entity.Passport;
import com.example.springjpahello.repo.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/passport")
public class PassportController {
    private Studentrepository StudentRepository;
    @Autowired
    private MessageSource messageSource;

    public PassportController(Studentrepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }
/*

    @GetMapping(value = "")
    public ResponseEntity<Passports> retrieveAllUsers() {
        List<Passport> passports=StudentRepository.getPassports();
        Passports p=new Passports();
        p.setPassports(passports);
        return ResponseEntity.ok(p);
    }
*/


    @GetMapping(value = "/json")
    public ResponseEntity<List<Passport>> retrieveAllPassport() {
        return ResponseEntity.ok(StudentRepository.getPassports());
    }

    @GetMapping(value = "/{passportNumber}")
    public ResponseEntity<?> retrieveAllUsers(@PathVariable("passportNumber") String passportNumber) {
        return ResponseEntity.ok(StudentRepository.getPassportByPassportNumber(passportNumber));
    }

}
