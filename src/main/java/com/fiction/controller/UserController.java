package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.bean.bo.LoginParamBo;
import com.fiction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
//@CrossOrigin(origins="*",maxAge=3600)
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    @CrossOrigin(origins = "*", maxAge = 3600)
    public BaseResponse login(@RequestBody LoginParamBo loginParamBo) {
        return userService.login(loginParamBo.getUserName(), loginParamBo.getPassword());
    }

    @PostMapping("/register")
    public BaseResponse register(@RequestBody LoginParamBo loginParamBo) {
        return userService.register(loginParamBo.getUserName(), loginParamBo.getPassword(), loginParamBo.getType());
    }

    @PostMapping("/changepas")
    public BaseResponse changePassword(@RequestBody LoginParamBo loginParamBo) {
        return userService.changePassword(loginParamBo.getUserName(), loginParamBo.getPassword());
    }

    @PostMapping("/logout")
    public BaseResponse logout(@RequestBody LoginParamBo loginParamBo) {
        return userService.logout(loginParamBo.getUserName());
    }
}
