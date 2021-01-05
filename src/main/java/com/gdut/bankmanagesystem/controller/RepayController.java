package com.gdut.bankmanagesystem.controller;


import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.Repay;
import com.gdut.bankmanagesystem.service.IRepayService;
import com.gdut.bankmanagesystem.utils.UUIDUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.Timestamp;

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
    public JSONResponse repay(@RequestBody Repay repay) {
        repay.setId(uuidUtil.getUUID());
        repay.setRepayTime(new Timestamp(System.currentTimeMillis()));
        iRepayService.repay(repay);
        return JSONResponse.success();
    }




}
