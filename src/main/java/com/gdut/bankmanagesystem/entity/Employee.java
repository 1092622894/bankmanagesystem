package com.gdut.bankmanagesystem.entity;

import java.sql.Timestamp;
import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp entryTime;

    /**
     * 角色（普通员工0/ 部门经理1）
     */
    private int role;

    /**
     * 部门id
     */
    private Long dId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Long getdId() {
        return dId;
    }

    public void setdId(Long dId) {
        this.dId = dId;
    }
}
