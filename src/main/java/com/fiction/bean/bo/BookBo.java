package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookBo {
    private Integer bookId;
    private Integer userId;
    private String bookName;
    private String bookAbstract;
    private Integer restrictFirstType;
    private Integer restrictSecondType;
}
