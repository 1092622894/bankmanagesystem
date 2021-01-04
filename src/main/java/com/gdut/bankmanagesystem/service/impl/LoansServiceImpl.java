package com.gdut.bankmanagesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.common.Constants;
import com.gdut.bankmanagesystem.common.exception.CustomException;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.ApproveLoanOrder;
import com.gdut.bankmanagesystem.entity.Bank;
import com.gdut.bankmanagesystem.entity.Loans;
import com.gdut.bankmanagesystem.mapper.AccountMapper;
import com.gdut.bankmanagesystem.mapper.ApproveLoanOrderMapper;
import com.gdut.bankmanagesystem.mapper.BankMapper;
import com.gdut.bankmanagesystem.mapper.LoansMapper;
import com.gdut.bankmanagesystem.service.ILoansService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.log.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static com.gdut.bankmanagesystem.common.Constants.EQUAL;
import static com.gdut.bankmanagesystem.common.Constants.LoanConstant.ISSUED;
import static com.gdut.bankmanagesystem.common.Constants.LoanConstant.ISSUED_FINISH;
import static com.gdut.bankmanagesystem.common.Constants.ZERO;

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
public class LoansServiceImpl extends ServiceImpl<LoansMapper, Loans> implements ILoansService {

    @Resource
    private LoansMapper loansMapper;
    @Resource
    private BankMapper bankMapper;
    @Resource
    private AccountMapper accountMapper;
    @Resource
    private ApproveLoanOrderMapper approveLoanOrderMapper;

    @Transactional
    @Override
    public Boolean approveSum(ApproveLoanOrder order) {
        log.info("尝试从id：{}分行扣除批准金额", order.getBId());
        Bank bank = assertExistBank(order.getBId());
        BigDecimal remainProperty = assertBankEnoughProperty(order.getSum(), bank.getProperty());
        UpdateWrapper<Bank> updateBank = new UpdateWrapper<>();
        updateBank.eq("id", bank.getId()).eq("property", bank.getProperty());
        bank.setProperty(remainProperty);
        bankMapper.update(bank, updateBank);
        log.info("尝试把id：{}的贷款单，更新贷款状态和贷款剩余未支付金额", order.getLId());
        Loans loan = assertExistLoan(order.getLId());
        BigDecimal amount = assertRightAmount(loan.getAmount(), order.getSum());
        loan.setProgress(amount.compareTo(ZERO) == EQUAL ? ISSUED_FINISH : ISSUED);
        UpdateWrapper<Loans> updateLoan = new UpdateWrapper<>();
        updateLoan.eq("id", loan.getId()).eq("amount", loan.getAmount());
        loan.setAmount(amount);
        loansMapper.updateById(loan);
        log.info("给id：{}贷款账户打钱!", loan.getAId());
        Account account = assertExistAccount(order.getAId());
        BigDecimal balance = account.getBalance();
        balance = balance.add(order.getSum());
        UpdateWrapper<Account> updateAccount = new UpdateWrapper<>();
        updateAccount.eq("id", account.getId()).eq("balance", account.getBalance());
        account.setBalance(balance);
        accountMapper.update(account, updateAccount);
        //把批准贷款单插入数据库
        log.info("尝试把单号：{}批准贷款单插入数据库",order.getId());
        approveLoanOrderMapper.insert(order);
        return true;
    }

    /**
     * 断言分行存在
     */
    private Bank assertExistBank(Long id) {
        Bank bank = bankMapper.selectById(id);
        if (bank == null) {
            log.error("贷款银行不存在");
            throw new CustomException("贷款银行不存在");
        }
        return bank;
    }

    /**
     * 断言分行钱足够贷款
     */
    private BigDecimal assertBankEnoughProperty(BigDecimal sum, BigDecimal property) {
        if (sum.compareTo(property) > 0) {
            log.error("银行余额不足以贷款！");
            throw new CustomException("银行余额不足以贷款！");
        }
        return property.subtract(sum);
    }


    /**
     * 断言存在该贷款
     */
    private Loans assertExistLoan(String id) {
        Loans loan = loansMapper.selectById(id);
        if (loan == null) {
            log.error("贷款不存在");
            throw new CustomException("贷款不存在！");
        }
        return loan;
    }

    /**
     * 断言批准金额合理
     */
    private BigDecimal assertRightAmount(BigDecimal loanAmount, BigDecimal sum) {
        if (loanAmount.compareTo(sum) < 1) {
            log.error("超出贷款余额范围！");
            throw new CustomException("超出贷款余额范围！");
        }
        return loanAmount.subtract(sum);
    }

    /**
     * 断言账户存在
     */
    private Account assertExistAccount(Long id) {
        Account account = accountMapper.selectById(id);
        if (account == null) {
            log.error("账户不存在!");
            throw new CustomException("账户不存在！");
        }
        return account;
    }
}
