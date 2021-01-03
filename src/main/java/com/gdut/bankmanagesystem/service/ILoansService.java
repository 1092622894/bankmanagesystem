package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.ApproveLoanOrder;
import com.gdut.bankmanagesystem.entity.Loans;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface ILoansService extends IService<Loans> {


    boolean approveSum(ApproveLoanOrder order);

}
