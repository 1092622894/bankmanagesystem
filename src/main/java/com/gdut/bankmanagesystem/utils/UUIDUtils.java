package com.gdut.bankmanagesystem.utils;

import java.util.UUID;

/**
 * 作为订单号
 */
public class UUIDUtils {

    public static String getUUID(){
         return UUID.randomUUID().toString();
    }

    public static void main(String[] args) {
        System.out.println("格式前的UUID ： " + UUID.randomUUID().toString());
        System.out.println("格式化后的UUID ：" + getUUID());
    }
}