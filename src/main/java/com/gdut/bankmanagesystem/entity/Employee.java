package com.gdut.bankmanagesystem.entity;

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
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工手机号码
     */
    private String phone;

    /**
     * 员工家庭地址
     */
    private String address;

    /**
     * 入职时间
     */
    private Timestamp entryTime;

    /**
     * 角色（普通员工0/ 部门经理1）
     */
    private int role;

    /**
     * 部门id
     */
    private Long dId;




}
