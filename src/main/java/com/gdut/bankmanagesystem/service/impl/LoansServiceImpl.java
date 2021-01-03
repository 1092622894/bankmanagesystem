package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.exception.CustomException;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.ApproveLoanOrder;
import com.gdut.bankmanagesystem.entity.Loans;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.mapper.ApproveLoanOrderMapper;
import com.gdut.bankmanagesystem.mapper.LoansMapper;
import com.gdut.bankmanagesystem.service.ILoansService;
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
public class LoansServiceImpl extends ServiceImpl<LoansMapper, Loans> implements ILoansService {

    @Resource
    private LoansMapper loansMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private ApproveLoanOrderMapper approveLoanOrderMapper;

    @Transactional
    @Override
    public boolean approveSum(ApproveLoanOrder order) {
        //贷款剩余金额
        Loans loan = loansMapper.selectById(order.getLId());
        double amount = loan.getAmount() - order.getSum();
        if (amount < 0) {
            throw new CustomException("超出贷款余额范围！");
        }
        //设置发放中
        loan.setProgress(1);
        if (amount == 0) {
            //设置发放完成
            loan.setProgress(2);
        }
        UpdateWrapper<Loans> updateLoan = new UpdateWrapper<>();
        updateLoan.eq("id", loan.getId()).eq("amount", loan.getAmount());
        loan.setAmount(amount);
        loansMapper.updateById(loan);
        //给该账户添加钱
        Account account = accountMapper.selectById(order.getAId());
        if (account == null) {
            throw new CustomException("账户不存在！");
        }
        Double balance = account.getBalance();
        balance += order.getSum();
        UpdateWrapper<Account> updateAccount = new UpdateWrapper<>();
        updateAccount.eq("id", account.getId()).eq("balance", account.getBalance());
        account.setBalance(balance);
        accountMapper.update(account, updateAccount);
        //把批准贷款单插入数据库
        approveLoanOrderMapper.insert(order);
        return true;
    }
}
