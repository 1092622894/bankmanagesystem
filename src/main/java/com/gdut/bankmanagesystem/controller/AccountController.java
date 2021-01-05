package com.gdut.bankmanagesystem.controller;


import com.alibaba.fastjson.JSON;
import com.gdut.bankmanagesystem.entity.Account;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.dto.AccountDTO;
import com.gdut.bankmanagesystem.service.IAccountService;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Resource
    private IAccountService iAccountService;
    @Resource
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 添加账号
     * @param account
     * @return
     */
    @PostMapping("/addAccount")
    public JSONResponse addAccount(@RequestBody Account account) {
        account.setId(snowFlakeUtil.getNextSnowFlakeId());
        account.setBalance(BigDecimal.ZERO);
        account.setInterestRate(new BigDecimal(0.12));
        account.setOverdraft(new BigDecimal(1000));
        account.setRecentTime(new Timestamp(System.currentTimeMillis()));
        if (iAccountService.save(account)) {
            return JSONResponse.success();
        }
        return JSONResponse.fail();
    }

    /**
     * 充值账户
     * @id 充值账户id
     * @amount 充值金额
     * @return
     */
    @PostMapping("/rechargeAccount")
    public JSONResponse rechargeAccount(@RequestBody AccountDTO accountDTO) {
        iAccountService.rechargeAccount(new Account(accountDTO));
        return JSONResponse.success();
    }

    /**
     * 取款账户
     * @id 账户id
     * @amount 取款金额
     * @return
     */
    @PostMapping("/drawAccount")
    public JSONResponse drawAccount(@RequestBody AccountDTO accountDTO) {
        iAccountService.drawAccount(new Account(accountDTO));
        return JSONResponse.success();
    }

}
