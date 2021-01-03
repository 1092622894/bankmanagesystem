package com.gdut.bankmanagesystem.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: blue
 * @Date: 2021/1/3 22:50
 * @ClassName ResponseCode
 * @Description: TODO
 * @version: 1.0
 */
@Getter
public enum ResponseCode {

    SUCCESS(200, "成功"),
    FAIL(100, "失败");

    private int code;   // 状态码
    private String message; //  信息

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
