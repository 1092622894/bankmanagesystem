package com.gdut.bankmanagesystem.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: blue
 */
@Getter
public enum ResponseCode {

    /**
     *
     */
    SUCCESS(200, "成功"),
    FAIL(100, "失败");

    /**
     * 状态码
     */
    private final int code;
    /**
     * 信息
     */
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
