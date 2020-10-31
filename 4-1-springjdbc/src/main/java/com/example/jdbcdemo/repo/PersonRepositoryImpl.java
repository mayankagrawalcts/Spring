package com.example.jdbcdemo.repo;

import com.example.jdbcdemo.exception.DaoException;
import com.example.jdbcdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.Connection;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public void savePerson(Person person){
        String sql = "insert into person(id,first_name,last_name) values (?,?,?)";
        Object[] params = new Object[]{person.getId(), person.getFirstName(), person.getLastName()};
            jdbcTemplate.update(sql, params);
          //  throw new NullPointerException();
    }


    @Override
    public List<Person> findAll() {
        String sql = "select * from person";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
    }



}
