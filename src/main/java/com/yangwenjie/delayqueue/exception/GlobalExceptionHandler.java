package com.yangwenjie.delayqueue.exception;

import com.yangwenjie.delayqueue.dto.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Create By IntelliJ IDEA
 * 全局异常处理
 * @author Yang WenJie
 * @date 2018/1/5 11:57
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        logger.error("系统出错",e);
        return Result.error().put("exception", e.getMessage());
    }
}
