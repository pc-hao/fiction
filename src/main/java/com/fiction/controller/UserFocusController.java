package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.UserIdBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fiction.service.UserFocusService;

@RestController
@RequestMapping("/userFocus")
public class UserFocusController {
    @Autowired
    UserFocusService userFocusService;

    @PostMapping("/getFocusAuthor")
    public BaseResponse getFocusAuthor(@RequestBody UserIdBo userIdBo) {
        return userFocusService.getFocusAuthorInformation(userIdBo.getUserId());
    }
}
