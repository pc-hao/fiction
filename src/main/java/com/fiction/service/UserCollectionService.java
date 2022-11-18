package com.fiction.service;

import com.fiction.bean.bo.*;
import com.fiction.entity.*;
import com.fiction.example.*;
import com.fiction.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.example.UserInformationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public BaseResponse getCollectionBooks(Integer userId) {
        UserCollectionExample example = new UserCollectionExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserCollectionKey> userCollectionKeys = userCollectionMapper.selectByExample(example);
        ArrayList<BookInforBo> bookInforBos = new ArrayList<>();
        for (UserCollectionKey userCollectionKey : userCollectionKeys) {
            BookExample bookExample = new BookExample();
            bookExample.createCriteria().andBookIdEqualTo(userCollectionKey.getBookId());
            Book book = bookMapper.selectOneByExample(bookExample);

            UserInformation writer = userInformationMapper.selectByPrimaryKey(book.getAuthorId());

            example = new UserCollectionExample();
            example.createCriteria().andBookIdEqualTo(book.getBookId());
            List<UserCollectionKey> otherCollections = userCollectionMapper.selectByExample(example);

            ChapterExample chapterExample = new ChapterExample();
            chapterExample.createCriteria().andBookIdEqualTo(book.getBookId());
            List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);

            BookInforBo bookInforBo = new BookInforBo(book.getBookId(),
                    book.getBookName(),
                    book.getCategory(),
                    book.getAuthorId(),
                    writer.getUserName(),
                    book.getBookabstract(),
                    book.getUpdatetime(),
                    book.getStartdate(),
                    book.getPicload(),  // todo
                    otherCollections.size(),
                    chapters.size()
            );
            bookInforBos.add(bookInforBo);
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(new UserCollectionBooksBo(bookInforBos)).build();
    }
}