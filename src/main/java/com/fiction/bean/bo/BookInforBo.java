package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookInforBo {
    private int bookId;
    private String bookName;
    private String category;
    private int authorId;
    private String bookWriter;
    private String bookAbstract;
    private String updateTime;
    private String startDate;
    private String picLoad;
    private int collectNum;
    private int chapterNum;
}