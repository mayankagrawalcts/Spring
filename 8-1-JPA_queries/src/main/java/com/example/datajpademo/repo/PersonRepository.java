package com.example.datajpademo.repo;

import com.example.datajpademo.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

}
