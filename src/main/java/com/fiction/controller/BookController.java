package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.BookIdAndChapterIdBo;
import com.fiction.bean.bo.BookIdBo;
import com.fiction.bean.bo.SearchBookBo;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.service.BookService;
import com.fiction.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
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


}