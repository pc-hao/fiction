package com.fiction.Enum;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BaseCodeEnum {
    FAIL(-1, "失败"),
    SUCCESS(0, "成功");

    private Integer code;
    private String message;
}
