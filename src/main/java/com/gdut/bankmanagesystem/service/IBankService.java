package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Bank;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gdut.bankmanagesystem.entity.view.BankView;

import java.util.List;

/**
 * @author blue
 * @since 2021-01-03
 */
public interface IBankService extends IService<Bank> {

    /**
     * 查询所有分行信息
     * @return
     */
    List<BankView> queryAllBank();
}
