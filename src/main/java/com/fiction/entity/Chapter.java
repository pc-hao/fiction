package com.fiction.entity;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class Chapter extends ChapterKey implements Serializable {
    private String chapterName;

    private String updateTime;

    private String chapterTxt;

    private static final long serialVersionUID = 1L;

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getChapterTxt() {
        return chapterTxt;
    }

    public void setChapterTxt(String chapterTxt) {
        this.chapterTxt = chapterTxt == null ? null : chapterTxt.trim();
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table chapter
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        bookId("book_id"),
        chapterId("chapter_id"),
        chapterName("chapter_name"),
        updateTime("update_time"),
        chapterTxt("chapter_txt");

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table chapter
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chapter
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chapter
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chapter
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column) {
            this.column = column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chapter
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.column + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table chapter
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.column + " ASC";
        }
    }
}