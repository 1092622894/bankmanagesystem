package com.gdut.bankmanagesystem.service.impl;

import com.gdut.bankmanagesystem.entity.Employee;
import com.gdut.bankmanagesystem.mapper.EmployeeMapper;
import com.gdut.bankmanagesystem.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryEmployeeByBankId(Long id) {
        return employeeMapper.queryEmployeeByBankId(id);
    }
}
