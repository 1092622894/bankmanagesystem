package com.gdut.bankmanagesystem.entity;

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
public class Loans implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 贷款总金额
     */
    private Double amount;

    /**
     * 贷款状态（未开始发放0/ 发放中1/ 已全部发放2）
     */
    private String progress;

    /**
     * 未还款金额
     */
    private Double remainAmount;


}
