package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginParamBo {
    private String userName;
    private String password;
    private Integer type;
}
