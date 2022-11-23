package com.fiction.Enum;

import java.util.HashMap;

public enum CountType {
    BOOK(1, "统计书籍数量"),
    COLLECTION(2, "统计收藏数量"),
    COMMENT(3, "统计评论数量"),
    ;

    private static HashMap<Integer, CountType> map;

    static {
        for (CountType item : CountType.values()) {
            map.put(item.getCode(), item);
        }
    }

    private Integer code;
    private String message;

    CountType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CountType getByCode(Integer code) {
        return map.get(code);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
