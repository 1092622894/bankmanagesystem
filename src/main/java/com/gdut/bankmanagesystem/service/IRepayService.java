package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.Repay;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author blue
 * @since 2021-01-03
 */
public interface IRepayService extends IService<Repay> {

    Boolean repay(Repay repay);

}
