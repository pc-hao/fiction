package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.BookInforBo;
import com.fiction.entity.Book;
import com.fiction.entity.UserCollectionKey;
import com.fiction.example.BookExample;
import com.fiction.example.UserCollectionExample;
import com.fiction.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserCollectionService {
    @Autowired
    UserFocusMapper userFocusMapper;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserCollectionMapper userCollectionMapper;

    @Autowired
    ChapterMapper chapterMapper;

    @Autowired
    BookService bookService;

    public BaseResponse getCollectionBooks(Integer userId) {
        UserCollectionExample example = new UserCollectionExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserCollectionKey> userCollectionKeys = userCollectionMapper.selectByExample(example);
        ArrayList<BookInforBo> bookInforBos = new ArrayList<>();
        for (UserCollectionKey userCollectionKey : userCollectionKeys) {
            BookExample bookExample = new BookExample();
            bookExample.createCriteria().andBookIdEqualTo(userCollectionKey.getBookId());
            Book book = bookMapper.selectOneByExample(bookExample);
            bookInforBos.add(bookService.bookToBookInfo(book));
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookInforBos).build();
    }

    public BaseResponse deleteCollection(Integer userId, Integer bookId) {
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        userCollectionExample.createCriteria().andUserIdEqualTo(userId).andBookIdEqualTo(bookId);
        userCollectionMapper.deleteByExample(userCollectionExample);
        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode()).Message("取消收藏成功").build();
    }

    public BaseResponse addCollection(Integer userId, Integer bookId) {
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        userCollectionExample.createCriteria().andUserIdEqualTo(userId).andBookIdEqualTo(bookId);
        List<UserCollectionKey> userCollectionKeys = userCollectionMapper.selectByExample(userCollectionExample);

        if (userCollectionKeys.size() != 0) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("收藏失败").build();
        }

        int result = userCollectionMapper
                .insert(UserCollectionKey.builder().userId(userId).bookId(bookId).build());

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("收藏成功").build();
    }

    public List<UserCollectionKey> getByBookId(Integer bookId) {
        UserCollectionExample userCollectionExample = new UserCollectionExample();
        userCollectionExample.createCriteria().andBookIdEqualTo(bookId);
        return userCollectionMapper.selectByExample(userCollectionExample);
    }

    public int countByBookId(Integer bookId) {
        return userCollectionMapper.countByBookId(bookId);
    }
}