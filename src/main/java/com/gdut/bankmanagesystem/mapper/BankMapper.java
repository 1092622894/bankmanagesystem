package com.gdut.bankmanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.bankmanagesystem.entity.Bank;
import com.gdut.bankmanagesystem.entity.view.BankView;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface BankMapper extends BaseMapper<Bank> {

    /**
     * 查询所有分行信息
     * @return
     */
    List<BankView> queryAllBank();

}
