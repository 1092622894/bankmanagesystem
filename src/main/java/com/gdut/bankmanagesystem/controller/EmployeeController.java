package com.gdut.bankmanagesystem.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.Department;
import com.gdut.bankmanagesystem.entity.Employee;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.service.IEmployeeService;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import jdk.nashorn.internal.objects.annotations.Getter;
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
    @Resource
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 添加员工
     * @param employee 员工信息
     * @return
     */
    @PostMapping("/addEmployee")
    public JSONResponse addEmployee(@RequestBody Employee employee) {
        System.out.println(JSON.toJSON(employee));
        employee.setId(snowFlakeUtil.getNextSnowFlakeId());
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
        System.out.println(JSON.toJSON(employee));
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
        queryWrapper.eq("d_id", id);
        List<Employee> employees = iEmployeeService.list(queryWrapper);
        return JSONResponse.success(employees);
    }

    /**
     * 查询某分行下所有员工
     * @param id 分行id
     * @return
     */
    @GetMapping("/queryEmployeeByBankId/{id}")
    public JSONResponse queryEmployeeByBankId(@PathVariable Long id) {
        List<Employee> employees = iEmployeeService.queryEmployeeByBankId(id);
        return JSONResponse.success(employees);
    }

    /**
     * 获取用户的开户申请
     * @return
     */
    @GetMapping("/listApplyAccount/{bId}")
    public JSONResponse listApplyAccount(@PathVariable("bId") Long bankId) {
        List<Account> result = iEmployeeService.listApplyAccount(bankId);
        return JSONResponse.success(result);
    }

    /**
     * 处理客户的开户申请
     * @param account 账户信息
     * @return
     */
    @PostMapping("/handleApplyAccount")
    public JSONResponse handleApplyAccount(@RequestBody Account account) {
        iEmployeeService.handleApplyAccount(account);
        return JSONResponse.success();
    }

    @GetMapping("/deleteAccount/{id}")
    public JSONResponse deleteAccount(@PathVariable("id") Long accountId) {
        iEmployeeService.deleteAccount(accountId);
        return JSONResponse.success();
    }

}
