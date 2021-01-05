package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.exception.CustomException;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.Bank;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.mapper.BankMapper;
import com.gdut.bankmanagesystem.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {


    @Resource
    private AccountMapper accountMapper;

    @Transactional
    @Override
    public Boolean rechargeAccount(Account account) {
        log.info("增加id：{}账户余额", account.getId());
        Account oldAccount = accountMapper.selectById(account.getId());
        Assert.notNull(oldAccount ,"账号不存在");
        UpdateWrapper<Account> updateAccount = new UpdateWrapper<>();
        updateAccount.eq("id", oldAccount.getId())
                .eq("balance", oldAccount.getBalance());
        account.setBalance(account.getBalance().add(oldAccount.getBalance()));
        accountMapper.update(account, updateAccount);
        return true;
    }

    @Transactional
    @Override
    public Boolean drawAccount(Account account) {
        log.info("减少id：{}账户余额", account.getId());
        Account oldAccount = accountMapper.selectById(account.getId());
        Assert.notNull(oldAccount ,"账号不存在");
        UpdateWrapper<Account> updateAccount = new UpdateWrapper<>();
        updateAccount.eq("id", oldAccount.getId())
                .eq("balance", oldAccount.getBalance());
        BigDecimal remainAmount = oldAccount.getBalance().subtract(account.getBalance());
        Assert.isTrue(remainAmount.compareTo(BigDecimal.ZERO) > -1, "余额不足！");
        account.setBalance(remainAmount);
        accountMapper.update(account, updateAccount);
        return true;
    }


}
