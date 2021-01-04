package com.gdut.bankmanagesystem.controller;


import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.Repay;
import com.gdut.bankmanagesystem.service.IRepayService;
import com.gdut.bankmanagesystem.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * 还款管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/repay")
public class RepayController {

    @Autowired
    private IRepayService iRepayService;

    @PostMapping("/repay")
    public JSONResponse repay(Repay repay) {
        repay.setId(UUIDUtils.getUUID());
        iRepayService.repay(repay);
        return JSONResponse.success();
    }




}
