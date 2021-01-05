package com.gdut.bankmanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.bankmanagesystem.entity.Employee;
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
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> queryEmployeeByBankId(@Param("id") Long id);

}
