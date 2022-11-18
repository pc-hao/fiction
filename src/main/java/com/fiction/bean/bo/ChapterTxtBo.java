package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChapterTxtBo {
    private int bookId;
    private int chapterId;
    private String updateTime;
    private String chapterName;
    private int wordNum;
    private String text;
}