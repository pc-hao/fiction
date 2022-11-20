package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CommentBo {
    private Integer commentId;
    private Integer bookId;
    private String bookName;
    private Integer userId;
    private String userName;
    private String commentTime;
    private String text;
}