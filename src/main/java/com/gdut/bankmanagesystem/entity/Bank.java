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
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 银行名字
     */
    private String name;

    /**
     * 该银行所在的城市
     */
    private String city;


}
