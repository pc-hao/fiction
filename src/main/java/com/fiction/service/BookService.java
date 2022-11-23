package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.*;
import com.fiction.bean.bo.*;
import com.fiction.entity.Book;
import com.fiction.entity.Chapter;
import com.fiction.entity.UserCollectionKey;
import com.fiction.entity.UserInformation;
import com.fiction.example.BookExample;
import com.fiction.example.ChapterExample;
import com.fiction.example.UserCollectionExample;
import com.fiction.mapper.BookMapper;
import com.fiction.mapper.ChapterMapper;
import com.fiction.mapper.UserCollectionMapper;
import com.fiction.mapper.UserInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @Lazy
    @Autowired
    UserCollectionService userCollectionService;

    @Autowired
    CommentService commentService;

    //  功能5
    public BookInforBo getBookInformation(Integer bookId) {
        return toBookInfo(bookMapper.selectByPrimaryKey(bookId));
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
                .body(chapterInforBos).build();
    }

    public BaseResponse getChapterTxt(Integer bookId, Integer chapterId) {
        ChapterExample example = new ChapterExample();
        example.createCriteria().andBookIdEqualTo(bookId).andChapterIdEqualTo(chapterId);
        Chapter chapter = chapterMapper.selectOneByExample(example);

        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode())
                .body(new ChapterTxtBo(chapter.getBookId(),
                        chapter.getChapterId(),
                        chapter.getUpdateTime(),
                        chapter.getChapterName(),
                        chapter.getChapterTxt().length(),
                        chapter.getChapterTxt()
                )).build();
    }

    public List<Book> getAuthorBooks(Integer userId) {
        BookExample example = new BookExample();
        example.createCriteria().andAuthorIdEqualTo(userId);
        List<Book> books = bookMapper.selectByExample(example);
        return books;
    }

    public List<BookInforBo> searchBook(SearchBookBo searchBookBo) {
        if (searchBookBo.getSearchType().equals(SearchType.AUTHOR.getCode())) {
            List<UserInformation> userInformations = userInformationMapper.selectByName(searchBookBo.getSearchText());
            return userInformations.stream().flatMap(
                    e -> getAuthorBooks(e.getUserId()).stream().map(this::toBookInfo)
            ).collect(Collectors.toList());
        }
        //其实这么写应该是有坑的，因为直接把所有书籍的信息读到内存里，在内存里做过滤，有可能信息太多了。
        return bookMapper.selectByName(searchBookBo.getSearchText()).stream()
                .filter(e -> filterBook(e, searchBookBo))
                .map(this::toBookInfo)
                .collect(Collectors.toList());
    }

    private boolean filterBook(Book book, SearchBookBo searchBookBo) {
        //这块处理逻辑写的简直了，可扩展性极差，先这样吧哈哈哈哈哈哈

        if ((searchBookBo.getRestrictFirstType() != 0 && !Objects.equals(book.getRestrictFirstType(), searchBookBo.getRestrictFirstType())) ||
                (searchBookBo.getRestrictSecondType() != 0 && !Objects.equals(book.getRestrictSecondType(), searchBookBo.getRestrictSecondType())) ||
                (searchBookBo.getRestrictFinish() != 0 && !Objects.equals(book.getFinish(), searchBookBo.getRestrictFinish()))) {
            return false;
        }

        //对章节数进行检查
        ChapterExample example = new ChapterExample();
        example.createCriteria().andBookIdEqualTo(book.getBookId());
        int chapterNum = chapterMapper.selectByExample(example).size();
        if ((searchBookBo.getRestrictChapter() == 1 && chapterNum > 10) ||
                (searchBookBo.getRestrictChapter() == 2 && (chapterNum < 10 || chapterNum > 30)) ||
                (searchBookBo.getRestrictChapter() == 3 && chapterNum <= 30)) {
            return false;
        }

        long day = ChronoUnit.DAYS.between(LocalDate.parse(book.getUpdatetime()), LocalDate.now());
        if ((searchBookBo.getRestrictUpdate() == 1 && day > 3) ||
                (searchBookBo.getRestrictUpdate() == 2 && day > 7) ||
                (searchBookBo.getRestrictUpdate() == 3 && day <= 7)) {
            return false;
        }

        return true;
    }

    public BookInforBo toBookInfo(Book book) {
        UserInformation writer = userInformationMapper.selectByPrimaryKey(book.getAuthorId());

        UserCollectionExample example = new UserCollectionExample();
        example.createCriteria().andBookIdEqualTo(book.getBookId());
        List<UserCollectionKey> otherCollections = userCollectionMapper.selectByExample(example);

        ChapterExample chapterExample = new ChapterExample();
        chapterExample.createCriteria().andBookIdEqualTo(book.getBookId());
        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);

        return new BookInforBo(book.getBookId(),
                book.getBookName(),
                book.getCategory(),
                book.getAuthorId(),
                writer.getUserName(),
                book.getBookabstract(),
                book.getUpdatetime(),
                book.getStartdate(),
                book.getPicload(),
                otherCollections.size(),
                chapters.size()
        );
    }

    public CountReturnBo countByFirstType(Integer restrictCode) {
        ArrayList<BookFirstType> bookFirstTypes = new ArrayList<>(Arrays.asList(BookFirstType.values()));
        List<List<Book>> booksList = bookFirstTypes.stream().map(this::getBooksByFirstType).collect(Collectors.toList());
        List<String> xData = bookFirstTypes.stream().map(BookFirstType::getName).collect(Collectors.toList());
        return count(booksList, xData, restrictCode);
    }

    private List<Book> getBooksByFirstType(BookFirstType firstType) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andRestrictFirstTypeEqualTo(firstType.getCode());
        return bookMapper.selectByExample(bookExample);
    }

    public CountReturnBo countBySecondType(CountBo countBo) {
        List<BookSecondType> bookSecondTypes = BookSecondType.getSecondTypeListByFirstType(BookFirstType.getByCode(countBo.getTypeCode()));
        List<List<Book>> booksList = bookSecondTypes.stream().map(this::getBooksBySecondType).collect(Collectors.toList());
        List<String> xData = bookSecondTypes.stream().map(BookSecondType::getName).collect(Collectors.toList());
        return count(booksList, xData, countBo.getRestrictCode());
    }

    private List<Book> getBooksBySecondType(BookSecondType bookSecondType) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andRestrictFirstTypeEqualTo(bookSecondType.getFirstType().getCode())
                .andRestrictSecondTypeEqualTo(bookSecondType.getCode());
        return bookMapper.selectByExample(bookExample);
    }

    private CountReturnBo count(List<List<Book>> booksList, List<String> xData, Integer restrictCode) {
        List<Integer> yData = new ArrayList<>();
        if (CountType.BOOK.getCode().equals(restrictCode)) {
            yData = booksList.stream().map(List::size).collect(Collectors.toList());
        } else if (CountType.COLLECTION.getCode().equals(restrictCode)) {
            yData = booksList.stream().map(
                            e -> e.stream().
                                    mapToInt(o -> userCollectionService.getByBookId(o.getBookId()).size()).sum())
                    .collect(Collectors.toList());
        } else if (CountType.COMMENT.getCode().equals(restrictCode)) {
            yData = booksList.stream().map(
                            e -> e.stream().
                                    mapToInt(o -> commentService.getByBookId(o.getBookId()).size()).sum())
                    .collect(Collectors.toList());
        }
        return new CountReturnBo(xData, yData);
    }
}
