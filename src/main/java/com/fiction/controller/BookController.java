package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.*;
import com.fiction.entity.Book;
import com.fiction.entity.Chapter;
import com.fiction.service.BookService;
import com.fiction.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    CommentService commentService;

    @PostMapping("/getAuthorBooks")
    public BaseResponse getAuthorBooks(@RequestBody UserIdBo userIdBo) {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookService.getAuthorBooks(userIdBo.getUserId()))
                .build();
    }

    @PostMapping("/getAuthorBookInfos")
    public BaseResponse getAuthorBookInfos(@RequestBody UserIdBo userIdBo) {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookService.getAuthorBookInfos(userIdBo.getUserId()))
                .build();
    }

    @PostMapping("/getInformation")
    public BaseResponse getInformation(@RequestBody BookIdBo bookIdBo) {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookService.getBookInformation(bookIdBo.getBookId())).build();
    }

    @PostMapping("/getAllChapter")
    public BaseResponse getChapter(@RequestBody BookIdBo bookIdBo) {
        return bookService.getAllChapter(bookIdBo.getBookId());
    }

    @PostMapping("/getChapterTxt")
    public BaseResponse getChapter(@RequestBody BookIdAndChapterIdBo bookIdAndChapterIdBo) {
        return bookService.getChapterTxt(bookIdAndChapterIdBo.getBookId()
                , bookIdAndChapterIdBo.getChapterId());
    }

    @PostMapping("/getComments")
    public BaseResponse getComments(@RequestBody BookIdBo bookIdBo) {
        return commentService.getBookComment(bookIdBo.getBookId());
    }

    @PostMapping("/search")
    public BaseResponse searchBook(@RequestBody SearchBookBo searchBookBo) {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookService.searchBook(searchBookBo)).build();
    }

    @PostMapping("/addBook")
    public BaseResponse addBook(@RequestBody BookBo bookBo) {
        bookService.addBook(bookBo);
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .build();
    }

    @PostMapping("/changeBookInfo")
    public BaseResponse changeBookInfo(@RequestBody BookBo bookBo) {
        Book book = bookService.changeBookInfo(bookBo);
        if (Objects.isNull(book)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.SUCCESS.getCode())
                    .Message("书籍不存在")
                    .build();
        }
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .build();
    }

    @PostMapping("/addChapter")
    public BaseResponse addChapter(@RequestBody ChapterTxtBo chapterTxtBo) {
        bookService.addChapter(chapterTxtBo);
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .build();
    }

    @PostMapping("/changeChapter")
    public BaseResponse changeChapter(@RequestBody ChapterTxtBo chapterTxtBo) {
        Chapter chapter = bookService.changeChapter(chapterTxtBo);
        if (Objects.isNull(chapter)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.SUCCESS.getCode())
                    .Message("章节不存在")
                    .build();
        }
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .build();
    }
}