package com.gdut.bankmanagesystem.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 余额
     */
    private Double balance;

    /**
     * 储蓄账户的利率
     */
    private Double interestRate;

    /**
     * 储蓄账户的货币类型
     */
    private String currencyType;

    /**
     * 支票账户的透支额度
     */
    private Double overdraft;

    /**
     * 最近访问时间
     */
    private LocalDateTime recentTime;

    /**
     * 账户类型（储蓄账户0/ 支票账户1）
     */
    private String type;

    /**
     * 银行主键id
     */
    private String bId;

    /**
     * 用户主键id
     */
    private String cId;


}
