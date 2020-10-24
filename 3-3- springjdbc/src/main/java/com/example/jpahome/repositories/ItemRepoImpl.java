package com.example.jpahome.repositories;

import com.example.jpahome.model.Items;
import com.example.jpahome.model.tableData;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepoImpl implements IItemRepo {
    final JdbcTemplate jdbcTemplate;

    public ItemRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public void saveItems(Items items) {
        var sql = "INSERT INTO items(name, price) VALUES (?, ?)";
        Object[] params = new Object[]{items.getName(), items.getPrice()};

        jdbcTemplate.update(sql, params);
    }

    @Override
    public Items findItemsByName(String name) {
        var sql = "SELECT * FROM items WHERE name = ?";
        Object[] param = new Object[]{name};

        return jdbcTemplate.queryForObject(sql, param,
                BeanPropertyRowMapper.newInstance(Items.class));
    }

    @Override
    public void printTable() {
        System.out.println(jdbcTemplate.getDataSource());
        System.out.println(jdbcTemplate.query("SELECT owner, table_name FROM all_tables", BeanPropertyRowMapper.newInstance(tableData.class)));
    }

    @Override
    public List<Items> findAll() {
        var sql = "SELECT * FROM items";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Items.class));
    }
}
