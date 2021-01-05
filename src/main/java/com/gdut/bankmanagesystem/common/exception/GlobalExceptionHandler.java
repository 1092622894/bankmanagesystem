package com.gdut.bankmanagesystem.common.exception;

import com.gdut.bankmanagesystem.entity.JSONResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 同一异常处理类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({CustomException.class})
    public JSONResponse handlerBusinessException(CustomException ce){
        logger.debug("发生业务异常 ---> 错误码:{}, 错误信息: {}", ce.getCode() , ce.getMessage());
        return JSONResponse.fail(ce.getCode(),ce.getMessage());
    }

    /**
     * 处理参数异常的方法
     * @param e 参数异常
     * @return 响应结果
     */
    @ExceptionHandler({IllegalArgumentException.class})
    public JSONResponse handlerIllegalArgumentException(IllegalArgumentException e){
        return JSONResponse.fail(e.getMessage());
    }



}
