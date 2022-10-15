package com.fiction.mapper;

import com.fiction.bean.Book;

import java.util.List;

public interface BookMapper {
    int addBook(Book book);
    List<Book> getAllbooks();
}
