package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.Employee;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.mapper.EmployeeMapper;
import com.gdut.bankmanagesystem.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Resource
    private AccountMapper accountMapper;

    @Override
    public List<Employee> queryEmployeeByBankId(Long id) {
        return employeeMapper.queryEmployeeByBankId(id);
    }

    @Override
    public void handleApplyAccount(Account account) {
        UpdateWrapper<Account> wrapper = new UpdateWrapper<>();
        wrapper.eq("c_id", account.getId());
        account.setOpenTime(new Timestamp(System.currentTimeMillis()));
        accountMapper.update(account, wrapper);
    }

    @Override
    public List<Account> listApplyAccount(Long bankId) {
        Map<String, Object> selectMap = new HashMap<>(2);
        selectMap.put("b_id", bankId);
        selectMap.put("status", Constants.ACCOUNT_STATUS_NOT_ISSUED);
        return accountMapper.selectByMap(selectMap);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountMapper.deleteById(accountId);
    }
}
