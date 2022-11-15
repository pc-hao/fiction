package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.LoginParamBo;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.bean.bo.UserInformationBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fiction.service.UserInformationService;

@RestController
@RequestMapping("/userInformation")
public class UserInformationController {
    @Autowired
    UserInformationService userInformationService;

    @PostMapping("/get")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public BaseResponse get(@RequestBody UserIdBo userIdBo) {
        return userInformationService.getAllInformation(userIdBo.getUserId());
    }

    @PostMapping("/update")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public BaseResponse update(@RequestBody UserInformationBo userInformationBo) {
        return userInformationService.update(userInformationBo);
    }
}
