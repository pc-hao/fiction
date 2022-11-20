package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.CollectionBo;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.service.UserCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fiction.service.UserFocusService;

@RestController
@RequestMapping("/userCollection")
public class UserCollectionController {
    @Autowired
    UserCollectionService userCollectionService;

    @PostMapping("/getCollectionBooks")
    public BaseResponse getCollectionBooks(@RequestBody UserIdBo userIdBo) {
        return userCollectionService.getCollectionBooks(userIdBo.getUserId());
    }

    @PostMapping("/delete")
    public BaseResponse delete(@RequestBody CollectionBo collectionBo) {
        return userCollectionService.deleteCollection(collectionBo.getUserId(), collectionBo.getBookId());
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestBody CollectionBo collectionBo) {
        return userCollectionService.addCollection(collectionBo.getUserId(), collectionBo.getBookId());
    }
}