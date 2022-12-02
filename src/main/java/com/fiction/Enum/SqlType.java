package com.fiction.Enum;

public enum SqlType {
    INSERT(1, "INSERT"),
    DELETE(2, "DELETE"),
    UPDATE(3, "UPDATE"),
    SELECT(4, "SELECT"),
    ;

    private Integer code;
    private String message;

    SqlType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
