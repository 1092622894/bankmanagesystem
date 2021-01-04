package com.gdut.bankmanagesystem.service.impl;

import com.gdut.bankmanagesystem.entity.Bank;
import com.gdut.bankmanagesystem.entity.view.BankView;
import com.gdut.bankmanagesystem.mapper.BankMapper;
import com.gdut.bankmanagesystem.service.IBankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements IBankService {

    @Resource
    private BankMapper bankMapper;

    @Override
    public List<BankView> queryAllBank() {
        return bankMapper.queryAllBank();
    }
}
