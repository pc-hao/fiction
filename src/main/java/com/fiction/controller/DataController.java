package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.CountBo;
import com.fiction.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    BookService bookService;

    @PostMapping("/first")
    public BaseResponse countByFirstType(@RequestBody CountBo countBo) {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookService.countByFirstType(countBo.getRestrictCode()))
                .build();
    }

    @PostMapping("/second")
    public BaseResponse countBySecondType(@RequestBody CountBo countBo) {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(bookService.countBySecondType(countBo))
                .build();
    }

}
