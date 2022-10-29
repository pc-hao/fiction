package com.fiction.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UserTypeEnum {
    DEVELOPER(0, "开发者"),
    WRITER(1, "作者"),
    READER(2, "读者")
    ;

    private Integer code;
    private String message;
}
