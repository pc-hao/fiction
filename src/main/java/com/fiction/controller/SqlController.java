package com.fiction.controller;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.UserIdBo;
import com.fiction.example.LogExample;
import com.fiction.mapper.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sql")
public class SqlController {
    @Autowired
    LogMapper logMapper;

    @PostMapping("/getAll")
    public BaseResponse getAll() {
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(logMapper.selectByExample(new LogExample())).build();
    }

    @PostMapping("/getByUid")
    public BaseResponse getByUid(@RequestBody UserIdBo userIdBo) {
        LogExample logExample = new LogExample();
        logExample.createCriteria().andUserIdEqualTo(userIdBo.getUserId());
        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(logMapper.selectByExample(logExample)).build();
    }
}
