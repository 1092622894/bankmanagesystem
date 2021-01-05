package com.gdut.bankmanagesystem.service.impl;

import com.gdut.bankmanagesystem.entity.Department;
import com.gdut.bankmanagesystem.entity.view.DepartmentView;
import com.gdut.bankmanagesystem.mapper.DepartmentMapper;
import com.gdut.bankmanagesystem.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public DepartmentView queryDepartmentInfoById(Long id) {
        Assert.notNull(id, "id不为空");
        DepartmentView departmentView = departmentMapper.queryDepartmentInfoById(id);
        Assert.notNull(departmentView, "获取不到部门信息");
        return departmentView;
    }

    @Override
    public List<DepartmentView> queryAllDepartment() {
        List<DepartmentView> departmentViews = departmentMapper.queryAllDepartmentInfo();
        Assert.notNull(departmentViews, "获取不到部门信息");
        return departmentViews;
    }
}
