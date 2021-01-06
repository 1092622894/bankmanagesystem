package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.common.exception.CustomException;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.dto.ApplyAccountDTO;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.service.IAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.math.BigDecimal;
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
@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements IAccountService {


    @Resource
    private AccountMapper accountMapper;
    final SnowFlakeUtil snowFlakeUtil;

    public AccountServiceImpl(SnowFlakeUtil snowFlakeUtil) {
        this.snowFlakeUtil = snowFlakeUtil;
    }

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

    @Override
    public void applyAccount(ApplyAccountDTO applyAccountDTO) {
        Map<String, Object> selectMap = new HashMap<>(2);
        selectMap.put("c_id", applyAccountDTO.getCId());
        selectMap.put("b_id", applyAccountDTO.getBId());
        selectMap.put("type", applyAccountDTO.getAccountType());
        List<Account> accounts = accountMapper.selectByMap(selectMap);
        if (accounts.size() == 1) {
            throw new CustomException("该用户在该银行下已经注册过同类的账户");
        }
        Account account = new Account();
        account.setId(snowFlakeUtil.getNextSnowFlakeId());
        account.setBalance(BigDecimal.ZERO);
        account.setStatus(Constants.ACCOUNT_STATUS_NOT_ISSUED);
        account.setBId(applyAccountDTO.getBId());
        account.setType(applyAccountDTO.getAccountType());
        account.setCId(applyAccountDTO.getCId());
        if (Constants.SAVING_ACCOUNT.equals(applyAccountDTO.getAccountType())) {
            account.setInterestRate(new BigDecimal(0.12));
            account.setCurrencyType("人民币");
        } else if (Constants.CHEQUE_ACCOUNT.equals(applyAccountDTO.getAccountType())) {
            account.setOverdraft(new BigDecimal(1000));
        }
        accountMapper.insert(account);
    }

    @Override
    public List<Account> listAccount(Long id) {
        Map<String, Object> selectMap = new HashMap<>(2);
        selectMap.put("c_id", id);
        selectMap.put("status", Constants.ACCOUNT_STATUS_PERMIT);
        return accountMapper.selectByMap(selectMap);
    }


}
