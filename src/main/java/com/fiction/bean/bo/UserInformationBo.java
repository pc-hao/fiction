package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserInformationBo {
    private int userId;
    private String userName;
    private String userSex;
    private String userEmail;
    private String userNation;
    private String userSentence;
}
