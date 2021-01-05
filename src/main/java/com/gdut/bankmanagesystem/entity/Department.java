package com.gdut.bankmanagesystem.entity;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author blue
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    public Long id;

    /**
     * 部门名称
     */
    private String name;

    /**
     * 部门所在的支行id
     */
    private Long bId;

    /**
     * 部门经理id
     */
    private Long eId;

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

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public Long geteId() {
        return eId;
    }

    public void seteId(Long eId) {
        this.eId = eId;
    }
}
