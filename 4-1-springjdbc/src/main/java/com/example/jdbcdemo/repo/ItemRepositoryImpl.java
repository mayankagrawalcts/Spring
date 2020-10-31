package com.example.jdbcdemo.repo;

import com.example.jdbcdemo.exception.DaoException;
import com.example.jdbcdemo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlTypeValue;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepositoryImpl implements Itemrepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void saveItem(Item item) {
        String sql="insert into item(id,name,price) values (?,?,?)";
        Object[] params=new Object[]{item.getId(),item.getName(),item.getPrice()};
        try {
            jdbcTemplate.update(sql, params);

        } catch (RuntimeException ex) {
            throw new DaoException(ex.getMessage());
        }
    }

    @Override
    public List<Item> findAll() {
    String sql="select * from item";
    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Item.class));
    }

}
