package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.entity.Repay;
import com.gdut.bankmanagesystem.entity.User;
import com.gdut.bankmanagesystem.mapper.*;
import com.gdut.bankmanagesystem.service.IRepayService;
import com.gdut.bankmanagesystem.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;

/**
 * @author honzooban
 * @version 1.0.0
 * @Description
 * @createTime 2021年01月04日 16:30:00
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    UserMapper userMapper;
    @Resource
    ClientMapper clientMapper;
    @Resource
    EmployeeMapper employeeMapper;
    @Resource
    AdminMapper adminMapper;

    @Override
    public User login(User user) {
        user.setPassword(new String(DigestUtils.md5Digest(user.getPassword().getBytes())));
        User result = userMapper.selectOne(new QueryWrapper<>(user, "id", "password", "role", "c_id", "e_id", "a_id"));
        Assert.notNull(result, "登录信息有误，请重新填写");
        return result;
    }

    @Override
    public Object getUserMessage(User user) {
        switch (user.getRole().toString()) {
            case Constants.CLIENT_ROLE:
                return clientMapper.selectById(user.getCId());
            case Constants.EMPLOYEE_ROLE:
            case Constants.MANAGER_ROLE:
                return employeeMapper.selectById(user.getEId());
            case Constants.BANK_ADMIN_ROLE:
                return adminMapper.selectById(user.getAId());
            default:
                throw new RuntimeException("权限异常，请重新登录");
        }
    }
}
