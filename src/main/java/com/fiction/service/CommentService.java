package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.CommentBo;
import com.fiction.entity.Book;
import com.fiction.entity.Comment;
import com.fiction.entity.UserInformation;
import com.fiction.example.BookExample;
import com.fiction.example.CommentExample;
import com.fiction.example.UserInformationExample;
import com.fiction.mapper.BookMapper;
import com.fiction.mapper.CommentMapper;
import com.fiction.mapper.UserInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Autowired
    CommentMapper commentMapper;

    public BaseResponse getBookComment(Integer bookId) {
        BookExample example = new BookExample();
        example.createCriteria().andBookIdEqualTo(bookId);
        Book book = bookMapper.selectOneByExample(example);

        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andBookIdEqualTo(bookId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        ArrayList<CommentBo> commentBos = new ArrayList<>();
        for (Comment comment : comments) {
            UserInformationExample userInformationExample = new UserInformationExample();
            userInformationExample.createCriteria().andUserIdEqualTo(comment.getUserId());
            UserInformation userInformation = userInformationMapper.selectOneByExample(userInformationExample);

            CommentBo commentBo = new CommentBo(comment.getCommentId(),
                    bookId,
                    book.getBookName(),
                    userInformation.getUserId(),
                    userInformation.getUserName(),
                    comment.getCommentTime(),
                    comment.getText());
            commentBos.add(commentBo);
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(commentBos).build();
    }


    public BaseResponse getUserComment(Integer userId) {
        UserInformationExample userInformationExample = new UserInformationExample();
        userInformationExample.createCriteria().andUserIdEqualTo(userId);
        UserInformation userInformation = userInformationMapper.selectOneByExample(userInformationExample);

        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andUserIdEqualTo(userId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);

        ArrayList<CommentBo> commentBos = new ArrayList<>();
        for (Comment comment : comments) {
            BookExample example = new BookExample();
            example.createCriteria().andBookIdEqualTo(comment.getBookId());
            Book book = bookMapper.selectOneByExample(example);

            CommentBo commentBo = new CommentBo(comment.getCommentId(),
                    book.getBookId(),
                    book.getBookName(),
                    userId,
                    userInformation.getUserName(),
                    comment.getCommentTime(),
                    comment.getText());
            commentBos.add(commentBo);
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(commentBos).build();
    }

    public BaseResponse deleteComment(Integer commentId) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andCommentIdEqualTo(commentId);
        commentMapper.deleteByExample(commentExample);
        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode()).Message("删除评论成功").build();
    }

    public BaseResponse addComment(Integer userId, Integer bookId, String text) {
        int result = commentMapper.insert(Comment.builder().userId(userId).bookId(bookId).text(text).build());

        if (result != 1) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("评论失败").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("评论成功").build();
    }

    public int countByBookId(Integer bookId) {
        return commentMapper.countByBookId(bookId);
    }
}
