package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.LoginParamBo;
import com.fiction.bean.bo.UserIdBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fiction.service.UserInformationService;

@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/getAllInformation")
    public BaseResponse getAllInformation(@RequestBody UserIdBo userIdBo) {
        return userInformationService.getAllInformation(userIdBo.getUserId());
    }

}
