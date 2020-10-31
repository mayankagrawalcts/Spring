package com.example.jdbcdemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@SpringBootTest
class DemoServiceImplTest {
     @Autowired
    DataSourceTransactionManager transactionManager;
     @Autowired
    DemoService demoService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void provideService() throws Exception{
       // TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        demoService.provideService();
//transactionManager.rollback(status);
    }
    @Test
    public void transaction3(){
        demoService.transaction3();
    }
}