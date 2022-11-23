package com.fiction.Enum;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum BookSecondType {
    EAST(1, BookFirstType.MYSTERIOUS, "东方玄幻"),
    WEST(2, BookFirstType.MYSTERIOUS, "西方玄幻"),
    ALIEN_CONTINENT(3, BookFirstType.MYSTERIOUS, "异世大陆"),

    FEATURE_WORLD(1, BookFirstType.SCIENCE, "未来世界"),
    SUPER_TEC(2, BookFirstType.SCIENCE, "超级科技"),
    EVOLUTIONARY(3, BookFirstType.SCIENCE, "进化变异"),

    URBAN_LIFE(1, BookFirstType.URBAN, "都市生活"),
    STRANGE(2, BookFirstType.URBAN, "奇人异术"),
    ENTERTAINMENT(3, BookFirstType.URBAN, "娱乐星路"),

    CHINESE_HISTORY(1, BookFirstType.HISTORY, "中华历史"),
    FOREIGN_HISTORY(2, BookFirstType.HISTORY, "外国历史"),
    ALTERNATE_HISTORY(3, BookFirstType.HISTORY, "架空历史"),

    PURE_LOVE(1, BookFirstType.ROMANCE, "纯爱唯美"),
    MARRIAGE(2, BookFirstType.ROMANCE, "婚姻职场"),
    IMPERIAL_FAMILY(3, BookFirstType.ROMANCE, "宫廷世家"),

    DETECTIVE(1, BookFirstType.SUSPENSE, "侦探推理"),
    ADVENTURE(2, BookFirstType.SUSPENSE, "探险生存"),
    SECRETIVE_TERROR(3, BookFirstType.SUSPENSE, "诡秘恐怖"),

    MODERN_WUXIA(1, BookFirstType.MARTIAL, "现代武侠"),
    ARCHAIC_WUXIA(2, BookFirstType.MARTIAL, "古代武侠"),
    FANTASTIC_WUXIA(3, BookFirstType.MARTIAL, "奇幻武侠"),
    ;

    private Integer code;
    private BookFirstType firstType;
    private String name;

    BookSecondType(Integer code, BookFirstType firstType, String name) {
        this.code = code;
        this.firstType = firstType;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public BookFirstType getFirstType() {
        return firstType;
    }

    public String getName() {
        return name;
    }

    public static BookSecondType getByCodeAndFirstType(int code, BookFirstType firstType) {
        for (BookSecondType item : BookSecondType.values()) {
            if (item.getCode() == code && Objects.equals(item.getFirstType(), firstType)) {
                return item;
            }
        }
        return null;
    }

    public static List<BookSecondType> getSecondTypeListByFirstType(BookFirstType firstType) {
        return Arrays.stream(BookSecondType.values()).filter(e -> e.getFirstType().equals(firstType)).collect(Collectors.toList());
    }
}
