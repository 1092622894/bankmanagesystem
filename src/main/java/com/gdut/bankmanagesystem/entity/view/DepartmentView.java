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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
