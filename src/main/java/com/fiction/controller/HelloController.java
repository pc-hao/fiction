package com.fiction.controller;

import com.fiction.bean.Book;
import com.fiction.entity.User;
import com.fiction.mapper.UserMapper;
import com.fiction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    BookService bookService;

    @Autowired
    UserMapper userMapper;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/addBook")
    public int addBook(@RequestParam String name, @RequestParam String author) {
        System.out.println("aaa");
        return bookService.addBook(new Book(name, author));
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/getPc")
    public User getPc() {
        return userMapper.selectByPrimaryKey(1);
    }
}
