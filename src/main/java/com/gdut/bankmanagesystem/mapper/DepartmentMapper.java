package com.gdut.bankmanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.bankmanagesystem.entity.Department;
import com.gdut.bankmanagesystem.entity.view.DepartmentView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 根据部门id查询部门信息
     * @param id 部门id
     * @return
     */
    DepartmentView queryDepartmentInfoById(@Param("id") Long id);

    /**
     * 查询所有部门信息
     * @return
     */
    List<DepartmentView> queryAllDepartmentInfo();
}
