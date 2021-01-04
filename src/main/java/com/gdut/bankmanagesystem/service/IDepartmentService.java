package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.bankmanagesystem.entity.view.DepartmentView;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface IDepartmentService extends IService<Department> {


    /**
     * 查询部门信息
     * @param id 部门id
     * @return
     */
    DepartmentView queryDepartmentInfoById(Long id);

    /**
     * 查询所有部门信息
     * @return
     */
    List<DepartmentView> queryAllDepartment();



}
