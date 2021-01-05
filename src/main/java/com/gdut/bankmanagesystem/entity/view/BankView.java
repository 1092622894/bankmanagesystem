package com.gdut.bankmanagesystem.entity.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.gdut.bankmanagesystem.entity.Bank;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minidev.json.annotate.JsonIgnore;

import java.math.BigDecimal;

/**
 * 银行视图类
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BankView extends Bank {

    //JSON格式化后，忽略财产
    @JSONField(serialize = false)
    private BigDecimal property;

    public static void main(String[] args) {
        Bank bank = new BankView();
        bank.setCity("广州");
        bank.setId(1L);
        bank.setName("起飞");
        bank.setProperty(new BigDecimal(10000));
        System.out.println(JSON.toJSON(bank));
    }

}
