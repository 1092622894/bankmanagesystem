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
public class Repay implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 还款时间
     */
    private LocalDateTime repayTime;

    /**
     * 还款金额
     */
    private Double repayAmount;

    /**
     * 贷款表主键id
     */
    private String lId;


}
