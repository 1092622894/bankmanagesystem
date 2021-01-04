package com.gdut.bankmanagesystem.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
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

    private Long id;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 储蓄账户的利率
     */
    private BigDecimal interestRate;

    /**
     * 储蓄账户的货币类型
     */
    private String currencyType;

    /**
     * 支票账户的透支额度
     */
    private BigDecimal overdraft;

    /**
     * 最近访问时间
     */
    private Timestamp recentTime;

    /**
     * 账户类型（储蓄账户0/ 支票账户1）
     */
    private String type;

    /**
     * 银行主键id
     */
    private Long bId;

    /**
     * 用户主键id
     */
    private Long cId;


}
