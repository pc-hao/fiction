package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.BookBo;
import com.fiction.bean.bo.UserFocusBo;
import com.fiction.bean.bo.UserFocusBos;
import com.fiction.entity.Book;
import com.fiction.entity.UserFocusKey;
import com.fiction.entity.UserInformation;
import com.fiction.example.BookExample;
import com.fiction.example.UserFocusExample;
import com.fiction.example.UserInformationExample;
import com.fiction.mapper.BookMapper;
import com.fiction.mapper.UserFocusMapper;
import com.fiction.mapper.UserInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserFocusService {
    @Autowired
    UserFocusMapper userFocusMapper;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Autowired
    BookMapper bookMapper;

    public BaseResponse getFocusAuthorInformation(Integer userId) {
        UserFocusExample example = new UserFocusExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserFocusKey> userFocuses = userFocusMapper.selectByExample(example);
        ArrayList<UserFocusBo> userFocusBos = new ArrayList<>();
        for (UserFocusKey userFocus : userFocuses) {
            if (Objects.isNull(userFocus)) {
                return BaseResponse.builder()
                        .code(BaseCodeEnum.FAIL.getCode())
                        .Message("用户不存在").build();
            }

            UserInformationExample informationExample = new UserInformationExample();
            informationExample.createCriteria().andUserIdEqualTo(userFocus.getAuthorId());
            UserInformation authorInformation = userInformationMapper.selectOneByExample(informationExample);
            ArrayList<BookBo> bookBos = new ArrayList<>();
            BookExample bookExample = new BookExample();
            bookExample.createCriteria().andAuthorIdEqualTo(authorInformation.getUserId());
            List<Book> books = bookMapper.selectByExample(bookExample);

            for (Book book : books) {
                BookBo bookBo = new BookBo(book.getBookId(), book.getBookName());
                bookBos.add(bookBo);
            }

            UserFocusBo userFocusBo = new UserFocusBo(authorInformation.getUserId(),
                    authorInformation.getUserName(), authorInformation.getSignature(),
                    bookBos);
            if (authorInformation.getType() == 1) {
                userFocusBos.add(userFocusBo);
            } else {
                System.out.println("the user " + userId + " focus not a author.");
            }
        }
        UserFocusBos userFocusBosF = new UserFocusBos(userFocusBos);

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(userFocusBosF).build();
    }
}
