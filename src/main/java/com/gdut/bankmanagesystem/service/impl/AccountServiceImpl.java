package com.gdut.bankmanagesystem.service.impl;

import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {


    @Autowired
    AccountMapper accountMapper;
}
