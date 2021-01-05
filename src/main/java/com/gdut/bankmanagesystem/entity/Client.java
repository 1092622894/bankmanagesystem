package com.gdut.bankmanagesystem.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 客户姓名
     */
    private String name;

    /**
     * 客户手机号码
     */
    private String phone;

    /**
     * 客户家庭地址
     */
    private String address;

    /**
     * 身份证号码
     */
    private String identifyCard;

    /**
     * contacts表主键id
     */
    @JsonProperty("cId")
    private Long cId;


}
