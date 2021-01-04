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
import java.math.BigDecimal;

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
        //2、断言有足够余额还款
        BigDecimal remainBalance = assertEnoughAmount(account.getBalance(), repay.getRepayAmount());
        UpdateWrapper<Account> updateAccount = new UpdateWrapper<>();
        updateAccount.eq("id", loan.getAId()).eq("balance", account.getBalance());
        account.setBalance(remainBalance);
        accountMapper.update(account, updateAccount);
        //3、贷款单中减掉还款金额
        BigDecimal remainAmount = assertRightRepay(loan.getRemainAmount(), repay.getRepayAmount());
        UpdateWrapper<Loans> updateLoan = new UpdateWrapper<>();
        updateLoan.eq("id", loan.getId()).eq("remainAmount", loan.getRemainAmount());
        loan.setRemainAmount(remainAmount);
        loansMapper.update(loan, updateLoan);
        //4、把还款信息保存在数据库中
        repayMapper.insert(repay);
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
    private Account assertAccountExist(Long id) {
        Account account = accountMapper.selectById(id);
        if(account == null) {
            throw new CustomException("账户不存在！");
        }
        return account;
    }

    /**
     * 断言余额足够
     * @param amount 余额
     * @param repayAmount 还款金额
     * @return
     */
    private BigDecimal assertEnoughAmount(BigDecimal amount, BigDecimal repayAmount) {
        if (amount.compareTo(repayAmount) < 0) {
            throw new CustomException("余额不足以还钱！");
        }
        return amount.subtract(repayAmount);
    }

    /**
     * 断言还钱小于等于要还款金额
     * @param remainAmount 要还款金额
     * @param repayAmount 还款金额
     * @return
     */
    private BigDecimal assertRightRepay(BigDecimal remainAmount, BigDecimal repayAmount) {
        if (remainAmount.compareTo(repayAmount) < 0) {
            throw new CustomException("还款过多！");
        }
        return remainAmount.subtract(remainAmount);
    }

}
