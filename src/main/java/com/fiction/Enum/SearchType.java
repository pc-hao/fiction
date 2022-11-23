package com.fiction.Enum;

public enum SearchType {
    AUTHOR(0),
    BOOK(1);

    private Integer code;

    SearchType(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
