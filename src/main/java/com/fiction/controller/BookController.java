package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.BookIdAndChapterIdBo;
import com.fiction.bean.bo.BookIdBo;
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


    @PostMapping("/getInformation")
    public BaseResponse getInformation(@RequestBody BookIdBo bookIdBo) {
        return bookService.getBookInformation(bookIdBo.getBookId());
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
}