package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FocusUserBo {
    private Integer authorId;
    private String authorName;
    private String authorSignature;
}