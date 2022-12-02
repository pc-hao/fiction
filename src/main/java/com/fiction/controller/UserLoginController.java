package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.FictionApplication;
import com.fiction.bean.bo.LoginParamBo;
import com.fiction.bean.bo.UserLoginBo;
import com.fiction.entity.UserInformation;
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
        try {
            UserInformation userInformation = userLoginService.login(loginParamBo.getUserName(), loginParamBo.getPassword());
            FictionApplication.Uid = userInformation.getUserId();
            return BaseResponse.builder()
                    .code(BaseCodeEnum.SUCCESS.getCode())
                    .body(new UserLoginBo(userInformation.getUserId(), userInformation.getType())).build();
        } catch (RuntimeException e) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message(e.getLocalizedMessage()).build();
        }
    }


    @PostMapping("/register")
    public BaseResponse register(@RequestBody LoginParamBo loginParamBo) {
        return userLoginService.register(loginParamBo.getUserName(), loginParamBo.getPassword(), loginParamBo.getType());
    }

    @PostMapping("/changepas")
    public BaseResponse changePassword(@RequestBody LoginParamBo loginParamBo) {
        return userLoginService.changePassword(loginParamBo.getUserName(), loginParamBo.getPassword());
    }

    @GetMapping("/logout")
    public BaseResponse logout(@RequestParam Integer userId) {
        return userLoginService.logout(userId);
    }
}
