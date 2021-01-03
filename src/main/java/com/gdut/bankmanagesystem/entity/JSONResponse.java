package com.gdut.bankmanagesystem.entity;

import com.gdut.bankmanagesystem.common.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * 返回通用类
 */
@Getter
@Setter
public class JSONResponse {
    private int code;
    private Object data;
    private String errMsg;
    private Timestamp timestamp;

    public static JSONResponse success(Object data) {
        JSONResponse response = success();
        response.setData(data);
        return response;
    }

    public static JSONResponse success() {
        JSONResponse response = new JSONResponse();
        response.setCode(ResponseCode.SUCCESS.getCode());
        response.setData(ResponseCode.SUCCESS.getMessage());
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        response.setErrMsg("");
        return response;
    }

    public static JSONResponse fail(int code, String msg) {
        JSONResponse response = fail(msg);
        response.setCode(code);
        return response;
    }

    public static JSONResponse fail(String msg) {
        JSONResponse response = fail();
        response.setErrMsg(msg);
        return response;
    }

    public static JSONResponse fail() {
        JSONResponse response = new JSONResponse();
        response.setCode(ResponseCode.FAIL.getCode());
        response.setErrMsg(ResponseCode.FAIL.getMessage());
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return response;
    }





}
