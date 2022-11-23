package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchBookBo {
    private String searchText;
    private Integer searchType;
    private Integer restrictFirstType;
    private Integer restrictSecondType;
    private Integer restrictUpdate;
    private Integer restrictChapter;
    private Integer restrictFinish;
}
