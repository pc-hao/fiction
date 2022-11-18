package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.Enum.UserTypeEnum;
import com.fiction.bean.bo.*;
import com.fiction.entity.*;
import com.fiction.example.BookExample;
import com.fiction.example.ChapterExample;
import com.fiction.example.UserCollectionExample;
import com.fiction.example.UserFocusExample;
import com.fiction.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserInformationMapper userInformationMapper;

    @Autowired
    UserCollectionMapper userCollectionMapper;

    @Autowired
    ChapterMapper chapterMapper;

    //  功能5
    public BaseResponse getBookInformation(Integer bookId) {
        BookExample example = new BookExample();
        example.createCriteria().andBookIdEqualTo(bookId);
        Book book = bookMapper.selectOneByExample(example);

        UserInformation writer = userInformationMapper.selectByPrimaryKey(book.getAuthorId());

        UserCollectionExample userCollectionExample = new UserCollectionExample();
        userCollectionExample.createCriteria().andBookIdEqualTo(book.getBookId());
        List<UserCollectionKey> otherCollections = userCollectionMapper.selectByExample(userCollectionExample);

        BookInforBo bookInforBo = new BookInforBo(book.getBookId(),
                book.getBookName(),
                book.getCategory(),
                book.getAuthorId(),
                writer.getUserName(),
                book.getBookabstract(),
                book.getUpdatetime(),
                book.getStartdate(),
                book.getPicload(),
                otherCollections.size(),   // todo
                0   // todo 章节功能尚未实现
        );

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookInforBo).build();
    }

    public BaseResponse getAllChapter(Integer bookId) {
        ChapterExample example = new ChapterExample();
        example.createCriteria().andBookIdEqualTo(bookId);
        List<Chapter> chapters = chapterMapper.selectByExample(example);
        ArrayList<ChapterInforBo> chapterInforBos = new ArrayList<>();

        for (Chapter chapter : chapters) {
            ChapterInforBo chapterInforBo = new ChapterInforBo();
            chapterInforBo.setBookId(chapter.getBookId());
            chapterInforBo.setChapterId(chapter.getChapterId());
            chapterInforBo.setChapterName(chapter.getChapterName());
            chapterInforBo.setUpdateTime(chapter.getUpdateTime());
            chapterInforBos.add(chapterInforBo);
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(new Book2ChapterBo(chapterInforBos)).build();
    }
}
