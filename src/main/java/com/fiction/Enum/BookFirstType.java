package com.fiction.Enum;

import java.util.HashMap;

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

    private static HashMap<Integer, BookFirstType> map;

    static {
        for (BookFirstType bookFirstType : BookFirstType.values()) {
            map.put(bookFirstType.getCode(), bookFirstType);
        }
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static BookFirstType getByCode(Integer code) {
        return map.get(code);
    }
}
