package com.gdut.bankmanagesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.gdut.bankmanagesystem.mapper")
@SpringBootApplication
public class BankmanagesystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankmanagesystemApplication.class, args);
    }

}
