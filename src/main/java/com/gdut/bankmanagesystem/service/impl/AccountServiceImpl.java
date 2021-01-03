package com.gdut.bankmanagesystem.service.impl;

import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.Test.mapper.AccountMapper;
import com.gdut.bankmanagesystem.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
