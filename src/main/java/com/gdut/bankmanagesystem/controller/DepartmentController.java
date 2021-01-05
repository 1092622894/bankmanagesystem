package com.gdut.bankmanagesystem.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.bankmanagesystem.entity.Department;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.view.DepartmentView;
import com.gdut.bankmanagesystem.service.IDepartmentService;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Resource
    private IDepartmentService iDepartmentService;
    @Resource
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 添加部门
     * @param department 部门信息
     * @return
     */
    @PostMapping("/addDepartment")
    public JSONResponse addDepartment(@RequestBody Department department) {
        department.setId(snowFlakeUtil.getNextSnowFlakeId());
        iDepartmentService.save(department);
        return JSONResponse.success();
    }

    /**
     * 查询部门信息
     * @param id 部门id
     * @return
     */
    @GetMapping("/queryDepartmentById/{id}")
    public JSONResponse queryDepartmentById(@PathVariable Long id) {
        DepartmentView departmentView = iDepartmentService.queryDepartmentInfoById(id);
        return JSONResponse.success(departmentView);
    }

    /**
     * 查询某个分行下所有部门
     * @param id 分行id
     * @return
     */
    @GetMapping("/queryAllDepartmentByBankId/{id}")
    public JSONResponse queryAllDepartmentByBankId(@PathVariable Long id) {
        QueryWrapper<Department> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("b_id", id);
        List<Department> list = iDepartmentService.list(queryWrapper);
        return JSONResponse.success(list);
    }

    /**
     * 查询所有部门信息
     * @return
     */
    @GetMapping("/queryAllDepartment")
    public JSONResponse queryAllDepartment() {
        List<DepartmentView> departmentViews = iDepartmentService.queryAllDepartment();
        return JSONResponse.success(departmentViews);
    }

    /**
     * 根据部门id删除部门
     * @return
     */
    @GetMapping("/deleteDepartmentById/{id}")
    public JSONResponse deleteDepartmentById(@PathVariable Long id) {
        iDepartmentService.removeById(id);
        return JSONResponse.success();
    }

    /**
     * 根据部门id更新部门信息
     * @return
     */
    @PostMapping("/updateDepartmentById")
    public JSONResponse updateDepartmentById(@RequestBody Department department) {
        iDepartmentService.updateById(department);
        return JSONResponse.success();
    }

}
