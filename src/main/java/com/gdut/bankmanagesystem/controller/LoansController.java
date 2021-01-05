package com.gdut.bankmanagesystem.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.entity.ApproveLoanOrder;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.Loans;
import com.gdut.bankmanagesystem.service.ILoansService;
import com.gdut.bankmanagesystem.utils.UUIDUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static com.gdut.bankmanagesystem.common.Constants.LoanConstant.NOT_ISSUED;
import static com.gdut.bankmanagesystem.common.Constants.LoanConstant.UNTREADTED;

/**
 * 贷款管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/loans")
public class LoansController {

    @Resource
    private ILoansService iLoansService;
    @Resource
    private UUIDUtil uuidUtil;

    /**
     * 提交贷款申请
     * @param loans 申请信息
     * @return
     */
    @PostMapping("/applyLoan")
    public JSONResponse applyLoan(Loans loans) {
        loans.setId(uuidUtil.getUUID());
        loans.setProgress(UNTREADTED);
        loans.setApprove(NOT_ISSUED);
        loans.setRemainAmount(loans.getAmount());
        if (iLoansService.save(loans)) {
            return JSONResponse.success();
        }
        return JSONResponse.fail();
    }

    /**
     * 查询申请状态
     * @param id 申请单id
     * @return
     */
    @GetMapping("/queryLoanState/{id}")
    public JSONResponse queryLoanState(@PathVariable String id) {
        Loans loans = iLoansService.getById(id);
        if (loans != null) {
            return JSONResponse.success(loans);
        }
        return JSONResponse.fail("该贷款不存在！");
    }

    /**
     * 查询所有贷款申请单
     * @param id 分行id
     * @return
     */
    @GetMapping("/queryAllLoan/{id}")
    public JSONResponse queryAllLoan(@PathVariable Long id) {
        List<Loans> list = iLoansService.queryAllLoan(id);
        return JSONResponse.success(list);
    }

    /**
     * 查询所有各种状态的贷款申请单
     * @return
     */
    @GetMapping("/queryLoan/{state}")
    public JSONResponse queryLoan(@PathVariable int state) {
        QueryWrapper<Loans> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("approve", state);
        List<Loans> list = iLoansService.list(queryWrapper);
        return JSONResponse.success(list);
    }

    /**
     * 更新批准还是拒绝贷款
     * @param id 贷款单id
     * @param approve 状态
     * @return
     */
    @PostMapping("/updateLoanState")
    public JSONResponse updateLoanState(@RequestParam String id, @RequestParam String approve) {
        UpdateWrapper<Loans> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("approve", approve);
        iLoansService.update(updateWrapper);
        return JSONResponse.success();
    }

    /**
     * 员工批准某用户多少贷款
     */
    @PostMapping("/approveSum")
    public JSONResponse approveSum(ApproveLoanOrder order) {
        order.setId(uuidUtil.getUUID());
        order.setTimestamp(new Timestamp(System.currentTimeMillis()));
        iLoansService.approveSum(order);
        return JSONResponse.success();
    }


}
