package com.gdut.bankmanagesystem.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minidev.json.annotate.JsonIgnore;

/**
 * @author blue
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 银行名字
     */
    private String name;

    /**
     * 该银行所在的城市
     */
    private String city;

    /**
     * 资产
     */
    private BigDecimal property;


}
