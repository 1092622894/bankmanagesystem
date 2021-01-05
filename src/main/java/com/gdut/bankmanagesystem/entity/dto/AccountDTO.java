package com.gdut.bankmanagesystem.entity.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @auther: blue
 * @Date: 2021/1/5 0:40
 * @ClassName AccountDTO
 * @Description: TODO
 * @version: 1.0
 */
@Data
public class AccountDTO {

    /**
     * 账户id
     */
    private Long id;

    /**
     * 充值金额
     */
    private BigDecimal amount;

}
