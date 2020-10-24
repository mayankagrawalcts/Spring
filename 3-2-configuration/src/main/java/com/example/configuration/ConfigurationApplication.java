package com.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import javax.sql.DataSource;

@Slf4j
@SpringBootApplication

public class ConfigurationApplication {

    public static void main(String[] args) {
       ApplicationContext applicationContext= SpringApplication.run(ConfigurationApplication.class, args);
        System.out.println("Hello world");
        DataSourceConfig dataSourceConfig=(DataSourceConfig) applicationContext.getBean(DataSourceConfig.class);
        System.out.println(dataSourceConfig);
        FakeDataSource fakeDataSource=(FakeDataSource)applicationContext.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource);
        FakeDataSource fakeDataSource1=(FakeDataSource)applicationContext.getBean("jmsSource");
        System.out.println(fakeDataSource1);
        log.info("slf4j:---"+fakeDataSource1);
        DataSource DataSource1=(DataSource) applicationContext.getBean(DataSource.class);
        System.out.println(DataSource1);
        DataSource DataSource2=(DataSource) applicationContext.getBean(DataSource.class);
        System.out.println(DataSource2);
    }
}
