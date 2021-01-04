package com.gdut.bankmanagesystem.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.gdut.bankmanagesystem.entity.ApproveLoanOrder;
import com.gdut.bankmanagesystem.entity.JSONResponse;
import com.gdut.bankmanagesystem.entity.Loans;
import com.gdut.bankmanagesystem.service.ILoansService;
import com.gdut.bankmanagesystem.utils.SnowFlakeUtil;
import com.gdut.bankmanagesystem.utils.UUIDUtils;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.util.List;

/**
 * 贷款管理
 * @author blue
 * @since 2021-01-03
 */
@RestController
@RequestMapping("/api/loans")
public class LoansController {

    @Autowired
    private ILoansService iLoansService;

    @PostMapping("/applyLoan")
    public JSONResponse applyLoan(Loans loans) {
        if (iLoansService.save(loans)) {
            return JSONResponse.success("申请成功，等待处理中！");
        }
        return JSONResponse.fail();
}

    @GetMapping("/queryLoanState/{id}")
    public JSONResponse queryLoanState(@PathVariable String id) {
        Loans loans = iLoansService.getById(id);
        if (loans != null) {
            return JSONResponse.success(loans);
        }
        return JSONResponse.fail("该贷款不存在！");
    }

    @GetMapping("/queryAllLoan")
    public JSONResponse queryAllLoan() {
        List<Loans> list = iLoansService.list();
        return JSONResponse.success(list);
    }

    @GetMapping("/updateLoanState")
    public JSONResponse updateLoanState(@RequestParam String id, @RequestParam String progress) {
        UpdateWrapper<Loans> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", id).set("progress", progress);
        iLoansService.update(updateWrapper);
        return JSONResponse.success();
    }

    /**
     * 员工批准某用户多少贷款
     */
    @PostMapping("/approveSum")
    public JSONResponse approveSum(ApproveLoanOrder order) {
        order.setId(UUIDUtils.getUUID());
        iLoansService.approveSum(order);
        return JSONResponse.success();
    }


}
