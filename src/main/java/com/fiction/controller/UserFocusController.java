package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.FocusBo;
import com.fiction.service.UserFocusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userFocus")
public class UserFocusController {
    @Autowired
    UserFocusService userFocusService;

//    @PostMapping("/add")
//    public BaseResponse addFocus(@RequestBody FocusBo focusBo) {
//        return null;
//    }

    @GetMapping("/get")
    public BaseResponse getFocusAuthor(@RequestParam Integer userId) {
        return userFocusService.getFocusAuthorInformation(userId);
    }

    @PostMapping("/delete")
    public BaseResponse delete(@RequestBody FocusBo focusBo) {
        return userFocusService.deleteFollow(focusBo.getUserId(), focusBo.getAuthorId());
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestBody FocusBo focusBo) {
        return userFocusService.addFollow(focusBo.getUserId(), focusBo.getAuthorId());
    }
}
