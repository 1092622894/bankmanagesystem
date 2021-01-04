package com.gdut.bankmanagesystem.entity.view;

import com.gdut.bankmanagesystem.entity.Bank;
import com.gdut.bankmanagesystem.entity.Department;
import com.gdut.bankmanagesystem.entity.Employee;
import lombok.Data;

/**
 * 部门视图类
 */
@Data
public class DepartmentView {

    public Long id;

    /**
     * 部门名称
     */
    private String departmentName;

    /**
     * 部门所在的支行的名字
     */
    private String bankName;

    /**
     * 部门所在的支行的城市
     */
    private String city;

    /**
     * 部门经理名字
     */
    private String employeeName;

}
