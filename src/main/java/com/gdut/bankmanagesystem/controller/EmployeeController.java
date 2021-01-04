package com.gdut.bankmanagesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.bankmanagesystem.entity.Department;
import com.gdut.bankmanagesystem.entity.Employee;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.service.IEmployeeService;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Resource
    private IEmployeeService iEmployeeService;


    /**
     * 添加员工
     * @param employee 员工信息
     * @return
     */
    @PostMapping("/addEmployee")
    public JSONResponse addEmployee(@RequestBody Employee employee) {
        employee.setId(SnowFlakeUtil.getNextSnowFlakeId());
        iEmployeeService.save(employee);
        return JSONResponse.success();
    }

    /**
     * 更新员工信息
     * @param employee 员工信息
     * @return
     */
    @PostMapping("/updateEmployee")
    public JSONResponse updateEmployee(@RequestBody Employee employee) {
        iEmployeeService.updateById(employee);
        return JSONResponse.success();
    }

    /**
     * 删除员工信息
     * @param id 员工ID
     * @return
     */
    @GetMapping("/deleteEmployee/{id}")
    public JSONResponse deleteEmployee(@PathVariable Long id) {
        iEmployeeService.removeById(id);
        return JSONResponse.success();
    }

    /**
     * 根据员工id查询某位员工信息
     * @param id 员工id
     * @return
     */
    @GetMapping("/queryEmployeeById/{id}")
    public JSONResponse queryEmployeeById(@PathVariable Long id) {
        Employee employee = iEmployeeService.getById(id);
        return JSONResponse.success(employee);
    }

    /**
     * 根据部门id查询该部门下的所有员工信息
     * @param id 部门id
     * @return
     */
    @GetMapping("/queryEmployeeByDepartmentId/{id}")
    public JSONResponse queryEmployeeByDepartmentId(@PathVariable Long id) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dId", id);
        List<Employee> employees = iEmployeeService.list(queryWrapper);
        return JSONResponse.success(employees);
    }

}
