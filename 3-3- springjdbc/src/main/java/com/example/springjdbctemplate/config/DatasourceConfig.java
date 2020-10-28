package com.example.springjdbctemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    private final Environment env;

    public DatasourceConfig(Environment env) {
        this.env = env;
    }

    @Bean(name = "manualDatasource")
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean(name = "manualTemplate")
    @Primary
    public JdbcTemplate jdbcTemplate() {

        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource());

        return template;
    }

    @Bean(name = "manualDatasource2")
    @Primary
    public DataSource dataSource2() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
        dataSource.setUrl(env.getProperty("jdbc.secondurl"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean(name = "manualTemplate2")
    public JdbcTemplate jdbcTemplate2() {

        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource2());

        return template;
    }
}