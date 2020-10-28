package com.example.springjdbctemplate.repositories;

import com.example.springjdbctemplate.model.Items;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemRepoImpl implements IItemRepo {
    final JdbcTemplate jdbcTemplate;
    final JdbcTemplate jdbcTemplate1;
    public ItemRepoImpl(@Qualifier("manualTemplate")JdbcTemplate jdbcTemplate, @Qualifier("manualTemplate2") JdbcTemplate jdbcTemplate1) {

        this.jdbcTemplate = jdbcTemplate;
        System.out.println("data source: "+(jdbcTemplate.getDataSource() == jdbcTemplate1.getDataSource()));
        this.jdbcTemplate1 = jdbcTemplate1;

    }

    @Override
    public void saveItems(Items items) {
        var sql = "INSERT INTO items(id,name, price) VALUES (?,?, ?)";
        Object[] params = new Object[]{items.getId(), items.getName(), items.getPrice()};

        jdbcTemplate.update(sql, params);
    }

    @Override
    public void saveItemsByManual(Items items) {
        var sql = "INSERT INTO items(id,name, price) VALUES (?,?, ?)";
        Object[] params = new Object[]{items.getId(), items.getName(), items.getPrice()};

        jdbcTemplate1.update(sql, params);
    }

    @Override
    public List<Items> findItemsByName(String name) {
        var sql = "SELECT * FROM items WHERE name = ?";
        Object[] param = new Object[]{name};

        return jdbcTemplate.query(sql, param,
                new ItemRowMapper());
    }

    @Override
    public List<Items> findAll() {
        var sql = "SELECT * FROM items";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Items.class));
    }

    class ItemRowMapper implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            Items item = new Items();
            item.setId(resultSet.getLong(1));
            item.setName(resultSet.getString(2));
            item.setPrice(resultSet.getInt(3));
            return item;
        }
    }
}
