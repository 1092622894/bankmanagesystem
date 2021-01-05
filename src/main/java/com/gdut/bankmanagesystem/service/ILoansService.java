package com.gdut.bankmanagesystem.service;

import com.gdut.bankmanagesystem.entity.ApproveLoanOrder;
import com.gdut.bankmanagesystem.entity.Loans;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface ILoansService extends IService<Loans> {

    /**
     * 批准贷款单
     * @param order
     * @return
     */
    Boolean approveSum(ApproveLoanOrder order);

    /**
     * 查询某个分行下的所有贷款单
     * @param id
     * @return
     */
    List<Loans> queryAllLoan(Long id);

}
