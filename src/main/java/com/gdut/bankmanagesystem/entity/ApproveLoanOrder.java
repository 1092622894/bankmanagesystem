package com.gdut.bankmanagesystem.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 员工每次批准贷款的流水单
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ApproveLoanOrder {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 账户id
     */
    private Long aId;

    /**
     * 贷款id
     */
    private String lId;

    /**
     * 贷款分行id
     */
    private Long bId;

    /**
     * 批准金额
     */
    private BigDecimal sum;

    /**
     * 批准时间
     */
    private Long timestamp;

}
