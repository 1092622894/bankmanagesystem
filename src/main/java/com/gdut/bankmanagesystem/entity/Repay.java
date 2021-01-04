package com.gdut.bankmanagesystem.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author blue
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Repay implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 还款时间
     */
    private Timestamp repayTime;

    /**
     * 还款金额
     */
    private BigDecimal repayAmount;

    /**
     * 贷款表主键id
     */
    private String lId;


}
