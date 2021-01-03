package com.gdut.bankmanagesystem;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class BankmanagesystemApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }


}
