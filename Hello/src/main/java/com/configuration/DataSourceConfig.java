package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
//@PropertySource("classpath:datasource.properties")
//@PropertySource("classpath:jmssource.properties")
@PropertySources({@PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jmssource.properties")
})
//@Profile("#{'${profile}'!=null ? '${profile}': 'local' }")
@Profile("!local")
public class DataSourceConfig {

    @Value("${db.oracle.password}")
    private String password;
    @Value("${db.oracle.username}")
    private String username;
    @Value("${db.oracle.info}")
    private String info;


    @Value("${db.jms.password}")
    private String jmspassword;
    @Value("${db.jms.username}")
    private String jmsusername;
    @Value("${db.jms.info}")
    private String jmsinfo;

    @Value("#{2+2}")
    double num;

    @Value("#{'${db.oracle.info}' !=null? '${db.oracle.info}'+' testing': 'default value'}")
    String data;

    @Autowired
    Environment env;

    @Bean
    @Primary
    public DataSource getMongoDS(){
        System.out.println("env: ----- "+env);
        System.out.println("env.getProperty(\"env\")-------"+env.getProperty("env")+env.getProperty("password"));
        FakeDataSource f=new FakeDataSource();
        f.setUsername(username);
        f.setPassword(env.getProperty("password") !=null ?env.getProperty("password") : password);
        f.setInfo(info);
        System.out.println("mongodb : --"+f);
        System.out.println("num----"+num);
        System.out.println("data----"+data);
        return f;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer=new PropertySourcesPlaceholderConfigurer();
        System.out.println("placeholder");
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean(name = "jmsSource")
    public DataSource getOracleDS(){
        FakeDataSource f=new FakeDataSource();
        f.setUsername(jmsusername);
        f.setPassword(jmspassword);
        f.setInfo(jmsinfo);
        System.out.println("fake data source: ------"+f);

        return f;
    }
}
