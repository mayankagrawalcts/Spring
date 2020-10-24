package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
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

    @Value("#{2+2}")
    double num;
    @Value("#{'${db.oracle.info}' !=null? '${db.oracle.info}'+' testing': 'default value'}")
    String data;
    
    @Autowired
    Environment env;

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

    @Bean
    @Scope(value = "prototype")
    @Primary
    public DataSource getMongoDS() {
        System.out.println("env: ----- " + env);
        System.out.println("env.getProperty(\"env\")-------" + env.getProperty("env") + env.getProperty("password"));
        FakeDataSource f = new FakeDataSource();
        f.setUsername(username);
        f.setPassword(env.getProperty("password") != null ? env.getProperty("password") : password);
        f.setInfo(info);
        System.out.println("mongodb new object created : --" + f);
        System.out.println(" property {db.oracle.info}"+"${db.oracle.info}");
        return f;
    }

    @Bean(name = "jmsSource")
    public DataSource getOracleDS() {
        FakeDataSource f = new FakeDataSource();
        f.setUsername(jmsusername);
        f.setPassword(jmspassword);
        f.setInfo(jmsinfo);
        System.out.println("fake data source: ------" + f);

        return f;
    }
}
