package com.fiction.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UserTypeEnum {
    READER(0, "读者"),
    WRITER(1, "作者"),
    DEVELOPER(2, "开发者");

    private Integer code;
    private String message;
}
