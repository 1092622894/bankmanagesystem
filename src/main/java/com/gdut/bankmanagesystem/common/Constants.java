package com.gdut.bankmanagesystem.common;

import java.math.BigDecimal;

/**
 * @auther: blue
 * @Date: 2021/1/4 1:43
 * @ClassName Constants
 * @Description: TODO
 * @version: 1.0
 */
public class Constants {

    public static final BigDecimal ZERO = new BigDecimal(0);



    public static final Integer INSERT_SUCCESS = 1;
    public static final Integer DELETE_SUCCESS = 1;
    public static final Integer UPDATE_SUCCESS = 1;

    /**
     * CLIENT_ROLE 客户角色
     * EMPLOYEE_ROLE 普通员工角色
     * MANAGER_ROLE 部门经理角色
     * BANK_ADMIN_ROLE 银行管理员角色
     */
    public static final String CLIENT_ROLE = "0";
    public static final String EMPLOYEE_ROLE = "1";
    public static final String MANAGER_ROLE = "2";
    public static final String BANK_ADMIN_ROLE = "3";

    /**
     * ACCOUNT_STATUS_NOT_ISSUED 账户已申请
     * ACCOUNT_STATUS_PERMIT 同意开户
     * ACCOUNT_STATUS_REFUSE 拒绝开户
     */
    public static final Integer ACCOUNT_STATUS_NOT_ISSUED = 0;
    public static final Integer ACCOUNT_STATUS_PERMIT = 1;
    public static final Integer ACCOUNT_STATUS_REFUSE = 2;
    public static final Integer SAVING_ACCOUNT = 0;
    public static final Integer CHEQUE_ACCOUNT = 1;

    public static class LoanConstant {

        /**
         * 批准贷款
         */
        public static final int AGREE_LOAN = 1;

        /**
         * 未处理贷款
         */
        public static final int UNTREADTED = 0;

        /**
         * 拒绝贷款
         */
        public static final int REFUSE_LOAN = -1;

        /**
         * 贷款未发放
         */
        public static final int NOT_ISSUED = 0;

        /**
         * 贷款发放中
         */
        public static final int ISSUED = 1;

        /**
         * 贷款发放完成
         */
        public static final int ISSUED_FINISH = 2;
    }

}