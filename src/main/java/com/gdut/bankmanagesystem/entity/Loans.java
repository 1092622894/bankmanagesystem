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

    private String id;

    /**
     * 贷款账户
     */
    private String aId;

    /**
     * 贷款总金额
     */
    private Double amount;

    /**
     * 1允许贷款，0未处理，-1拒绝贷款
     */
    private int approve;

    /**
     * 贷款状态（未发放0/ 发放中1/已全部发放2）
     */
    private int progress;

    /**
     * 未还款金额
     */
    private Double remainAmount;


}
