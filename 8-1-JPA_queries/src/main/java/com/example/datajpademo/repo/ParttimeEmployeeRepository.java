package com.example.datajpademo.repo;

import com.example.datajpademo.model.Employee;
import com.example.datajpademo.model.ParttimeEmployee;
import org.springframework.data.repository.CrudRepository;

public interface ParttimeEmployeeRepository extends CrudRepository<ParttimeEmployee,Long> {
}
