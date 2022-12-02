package com.fiction.Enum;

public enum BookFirstType {
    MYSTERIOUS(1, "玄幻"),
    SCIENCE(2, "科幻"),
    URBAN(3, "都市"),
    HISTORY(4, "历史"),
    ROMANCE(5, "言情"),
    SUSPENSE(6, "悬疑"),
    MARTIAL(7, "武侠");

    private Integer code;
    private String name;

    BookFirstType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static BookFirstType getByCode(Integer code) {
        for (BookFirstType item : BookFirstType.values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return null;
    }
}
