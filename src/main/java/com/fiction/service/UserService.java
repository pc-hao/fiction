package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.UserBo;
import com.fiction.entity.User;
import com.fiction.example.UserExample;
import com.fiction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public BaseResponse login(String userName, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        User user = userMapper.selectOneByExample(example);
        if (Objects.isNull(user)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户不存在").build();
        }

        if (!Objects.equals(password, user.getPassword())) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("密码错误").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(new UserBo(user.getType())).build();
    }

    public BaseResponse register(String userName, String password, Integer type) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        User user = userMapper.selectOneByExample(example);
        if (Objects.nonNull(user)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户名已存在").build();
        }

        int result = userMapper.insert(User.builder().userName(userName).password(password).type(type).build());

        if (result != 1) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("注册失败").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("注册成功").build();
    }

    public BaseResponse changePassword(String userName, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        User user = userMapper.selectOneByExample(example);
        if (Objects.isNull(user)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户不存在").build();
        }

        int result = userMapper.updateByPrimaryKeySelective(User.builder().userId(user.getUserId()).userName(userName).password(password).build());

        if (result != 1) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("修改失败").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("修改成功").build();
    }

    public BaseResponse logout(String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        userMapper.deleteByExample(example);
        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode()).build();
    }
}
