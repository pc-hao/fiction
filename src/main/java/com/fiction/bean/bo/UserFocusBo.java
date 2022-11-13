package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFocusBo {
    private Integer authorId;
    private String authorName;
    private String authorSignature;
    private ArrayList<BookBo> books;
}