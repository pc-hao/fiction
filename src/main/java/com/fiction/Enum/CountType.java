package com.fiction.Enum;

public enum CountType {
    BOOK(0, "统计书籍数量"),
    COLLECTION(1, "统计收藏数量"),
    COMMENT(2, "统计评论数量"),
    ;

    private Integer code;
    private String message;

    CountType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CountType getByCode(Integer code) {
        for (CountType item : CountType.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
