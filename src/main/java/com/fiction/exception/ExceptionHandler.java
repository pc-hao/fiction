package com.fiction.exception;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public BaseResponse handler(RuntimeException e) {
        //这段代码没啥用，试了一下发现返回的是404，不知道为什么。
        return BaseResponse.builder()
                .code(BaseCodeEnum.FAIL.getCode())
                .build();
    }
}
