package com.gdut.bankmanagesystem.controller;


import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.Repay;
import com.gdut.bankmanagesystem.service.IRepayService;
import com.gdut.bankmanagesystem.utils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 还款管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/repay")
public class RepayController {

    @Resource
    private IRepayService iRepayService;
    @Resource
    private UUIDUtil uuidUtil;

    @PostMapping("/repay")
    public JSONResponse repay(Repay repay) {
        repay.setId(uuidUtil.getUUID());
        iRepayService.repay(repay);
        return JSONResponse.success();
    }




}
