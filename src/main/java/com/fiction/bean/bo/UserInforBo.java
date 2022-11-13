package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserInforBo {
    private int userId;
    private String password;
    private String userSex;
    private String userEmail;
    private String userNation;
    private String userSentence;
}
