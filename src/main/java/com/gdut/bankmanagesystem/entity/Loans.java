package com.gdut.bankmanagesystem.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author blue
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Loans implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 贷款账户
     */
    private Long aId;

    /**
     * 贷款总金额
     */
    private BigDecimal amount;

    /**
     * 1允许贷款，0未处理，-1拒绝贷款
     */
    private Integer approve;

    /**
     * 贷款状态（未发放0/ 发放中1/已全部发放2）
     */
    private Integer progress;

    /**
     * 未还款金额
     */
    private BigDecimal remainAmount;
}
