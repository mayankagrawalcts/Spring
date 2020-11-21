package com.example.datajpademo.repo;

import com.example.datajpademo.model.Employee;
import com.example.datajpademo.model.FulltimeEmployee;
import org.springframework.data.repository.CrudRepository;

public interface FulltimeEmployeeRepository extends CrudRepository<FulltimeEmployee,Long> {
}
