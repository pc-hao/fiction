package com.fiction.service;

import com.fiction.bean.Book;
import com.fiction.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookMapper bookMapper;

    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    public List<Book> getAllBooks() {
        return bookMapper.getAllbooks();
    }
}
