package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.Enum.UserTypeEnum;
import com.fiction.bean.bo.*;
import com.fiction.entity.*;
import com.fiction.example.*;
import com.fiction.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                .body(new CommentsBo(commentBos)).build();
    }


}
