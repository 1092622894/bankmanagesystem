package com.gdut.bankmanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.bankmanagesystem.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface AccountMapper extends BaseMapper<Account> {

}
