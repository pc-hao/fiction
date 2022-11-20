package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.BookIdAndChapterIdBo;
import com.fiction.bean.bo.BookIdBo;
import com.fiction.bean.bo.CommentIdBo;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.service.BookService;
import com.fiction.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userComment")
public class UserCommentController {
    @Autowired
    BookService bookService;

    @Autowired
    CommentService commentService;

    @PostMapping("/get")
    public BaseResponse getComments(@RequestBody UserIdBo userIdBo) {
        return commentService.getUserComment(userIdBo.getUserId());
    }

    @PostMapping("/delete")
    public BaseResponse getComments(@RequestBody CommentIdBo commentIdBo) {
        commentService.deleteComment(commentIdBo.getCommentId());
        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode()).build();
    }
}
