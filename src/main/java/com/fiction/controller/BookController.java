package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.BookBo;
import com.fiction.bean.bo.BookIdAndChapterIdBo;
import com.fiction.bean.bo.BookIdBo;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.entity.Book;
import com.fiction.service.BookService;
import com.fiction.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fiction.service.UserFocusService;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

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
}