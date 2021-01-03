package com.gdut.bankmanagesystem.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用异常类
 */
@Setter
@Getter
public class CustomException extends RuntimeException{
    private int code;
    private String message;
    private Object data;


    public CustomException(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = "";
    }

    public CustomException(String message) {
        this.code = 100;
        this.message = message;
        this.data = "";
    }

}
