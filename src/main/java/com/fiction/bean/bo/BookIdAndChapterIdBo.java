package com.fiction.bean.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookIdAndChapterIdBo {
    private Integer bookId;
    private Integer chapterId;
}
