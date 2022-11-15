package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.LoginParamBo;
import com.fiction.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    UserLoginService userLoginService;

    @PostMapping("/login")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public BaseResponse login(@RequestBody LoginParamBo loginParamBo) {
        return userLoginService.login(loginParamBo.getUserName(), loginParamBo.getPassword());
    }


    @PostMapping("/register")
    public BaseResponse register(@RequestBody LoginParamBo loginParamBo) {
        return userLoginService.register(loginParamBo.getUserName(), loginParamBo.getPassword(), loginParamBo.getType());
    }

    @PostMapping("/changepas")
    public BaseResponse changePassword(@RequestBody LoginParamBo loginParamBo) {
        return userLoginService.changePassword(loginParamBo.getUserName(), loginParamBo.getPassword());
    }

    @PostMapping("/logout")
    public BaseResponse logout(@RequestBody Integer userId) {
        return userLoginService.logout(userId);
    }
}
