package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.bean.bo.UserInformationBo;
import com.fiction.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/get")
    public BaseResponse get(@RequestBody UserIdBo userIdBo) {
        return userInformationService.getAllInformation(userIdBo.getUserId());
    }

    @PostMapping("/update")
    public BaseResponse update(@RequestBody UserInformationBo userInformationBo) {
        return userInformationService.update(userInformationBo);
    }
}
