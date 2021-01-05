package com.gdut.bankmanagesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdut.bankmanagesystem.entity.Loans;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author blue
 * @since 2021-01-03
 */
public interface LoansMapper extends BaseMapper<Loans> {

    /**
     * 查询某个分行下的所有贷款单
     * @return
     */
    List<Loans> queryAllLoan(@Param("id") Long id);

}
