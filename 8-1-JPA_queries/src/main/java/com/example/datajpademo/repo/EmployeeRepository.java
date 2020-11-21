package com.example.datajpademo.repo;

import com.example.datajpademo.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository  extends CrudRepository<Employee,Long> {
}
