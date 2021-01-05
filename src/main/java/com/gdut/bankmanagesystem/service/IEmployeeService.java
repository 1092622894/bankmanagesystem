package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface IEmployeeService extends IService<Employee> {

    List<Employee> queryEmployeeByBankId(Long id);
}
