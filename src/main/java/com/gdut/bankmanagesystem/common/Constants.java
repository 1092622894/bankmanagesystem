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

    public static final int EQUAL = 0;

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
