package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Account;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface IAccountService extends IService<Account> {

    /**
     * 用户充值
     * @param account 充值信息
     * @return
     */
    Boolean rechargeAccount(Account account);

    /**
     * 取款
     * @return
     */
    Boolean drawAccount(Account account);

}
