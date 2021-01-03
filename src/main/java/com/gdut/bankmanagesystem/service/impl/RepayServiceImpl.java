package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.exception.CustomException;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.Loans;
import com.gdut.bankmanagesystem.entity.Repay;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.mapper.LoansMapper;
import com.gdut.bankmanagesystem.mapper.RepayMapper;
import com.gdut.bankmanagesystem.service.IRepayService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class RepayServiceImpl extends ServiceImpl<RepayMapper, Repay> implements IRepayService {

    @Resource
    private RepayMapper repayMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private LoansMapper loansMapper;

    @Transactional
    @Override
    public Boolean repay(Repay repay) {
        //0 根据贷款id，获取贷款信息
        Loans loan = assertLoanExist(repay.getLId());
        //1、根据账户id，获取账户信息
        Account account = assertAccountExist(loan.getAId());
        //2、判断是否有足够余额还款
        //2.1、不足，抛出异常，结束
        if (account.getBalance() < repay.getRepayAmount()) {
            throw new CustomException("余额不足以还钱！");
        }
        //2.2、足够，对账户进行扣钱处理
        Double remainBalance = account.getBalance() - repay.getRepayAmount();
        UpdateWrapper<Account> updateAccount = new UpdateWrapper<>();
        updateAccount.eq("id", loan.getAId()).eq("balance", account.getBalance());
        account.setBalance(remainBalance);
        accountMapper.update(account, updateAccount);
        //3、贷款单中减掉还款金额
        Double remainAmount = loan.getRemainAmount() - repay.getRepayAmount();
        if (remainAmount < 0) {
            throw new CustomException("还款过多！");
        }
        UpdateWrapper<Loans> updateLoan = new UpdateWrapper<>();
        updateLoan.eq("id", loan.getId()).eq("remainAmount", loan.getRemainAmount());
        loan.setRemainAmount(remainAmount);
        loansMapper.update(loan, updateLoan);
        return true;
    }

    /**
     * 断言贷款存在
     */
    private Loans assertLoanExist(String id) {
        Loans loan = loansMapper.selectById(id);
        if (loan == null) {
            throw new CustomException("贷款不存在！");
        }
        return loan;
    }

    /**
     * 断言账户存在
     */
    private Account assertAccountExist(String id) {
        Account account = accountMapper.selectById(id);
        if(account == null) {
            throw new CustomException("账户不存在！");
        }
        return account;
    }
}
