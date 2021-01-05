package com.gdut.bankmanagesystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdut.bankmanagesystem.entity.Bank;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.view.BankView;
import com.gdut.bankmanagesystem.service.IBankService;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支行管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Resource
    private IBankService iBankService;
    @Resource
    private SnowFlakeUtil snowFlakeUtil;

    /**
     * 查询某个分行信息
     * @param id 分行id
     * @return
     */
    @GetMapping("/queryById/{id}")
    public JSONResponse queryById(@PathVariable Long id) {
        Bank bank = iBankService.getById(id);
        return JSONResponse.success(bank);
    }

    /**
     * 查询所有分行信息
     * @return
     */
    @GetMapping("/queryAllBank")
    public JSONResponse queryAllBank() {
        List<BankView> bankViewList = iBankService.queryAllBank();
        return JSONResponse.success(bankViewList);
    }

    /**
     * 添加分行
     * @param bank 分行信息
     * @return
     */
    @PostMapping("/addBank")
    public JSONResponse addBank(@RequestBody Bank bank) {
        bank.setId(snowFlakeUtil.getNextSnowFlakeId());
        iBankService.save(bank);
        return JSONResponse.success();
    }

    /**
     * 更新分行
     * @param bank 分行信息
     * @return
     */
    @PostMapping("/updateBank")
    public JSONResponse updateBank(@RequestBody Bank bank) {
        iBankService.updateById(bank);
        return JSONResponse.success();
    }

    /**
     * 删除分行
     * @param id 分行id
     * @return
     */
    @GetMapping("/deleteBankById/{id}")
    public JSONResponse deleteBankById(@PathVariable Long id) {
        if (iBankService.removeById(id)) {
            return JSONResponse.success();
        }
        return JSONResponse.fail();
    }

}
