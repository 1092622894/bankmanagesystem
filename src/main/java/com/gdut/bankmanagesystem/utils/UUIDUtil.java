package com.gdut.bankmanagesystem.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 作为订单号
 */
@Component
public class UUIDUtil {

    public String getUUID(){
         return UUID.randomUUID().toString().replace("-", "");
    }

    public static void main(String[] args) {
        System.out.println("格式前的UUID ： " + new UUIDUtil().getUUID());
    }
}