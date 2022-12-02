package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.entity.UserInformation;
import com.fiction.entity.UserLogin;
import com.fiction.example.UserLoginExample;
import com.fiction.mapper.UserInformationMapper;
import com.fiction.mapper.UserLoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserLoginService {
    @Autowired
    UserLoginMapper userLoginMapper;

    @Autowired
    UserInformationMapper userInformationMapper;

    public UserInformation login(String userName, String password) {
        UserLoginExample example = new UserLoginExample();
        example.createCriteria().andUserNameEqualTo(userName);
        UserLogin userLogin = userLoginMapper.selectOneByExample(example);

        PredictionUtils.check(Objects.isNull(userLogin), "用户不存在");
        PredictionUtils.check(!Objects.equals(password, userLogin.getPassword()), "密码错误");

        return userInformationMapper.selectByPrimaryKey(userLogin.getUserId());
    }

    public BaseResponse register(String userName, String password, Integer type) {
        UserLoginExample example = new UserLoginExample();
        example.createCriteria().andUserNameEqualTo(userName);
        UserLogin userLogin = userLoginMapper.selectOneByExample(example);
        if (Objects.nonNull(userLogin)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户名已存在").build();
        }

        int result = userLoginMapper.insert(UserLogin.builder().userName(userName).password(password).build());
        userLogin = userLoginMapper.selectOneByExample(example);

        if (result != 1) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("注册失败").build();
        }

        userInformationMapper.insertSelective(UserInformation.builder()
                .userId(userLogin.getUserId())
                .userName(userLogin.getUserName())
                .type(type).build());

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("注册成功").build();
    }

    public BaseResponse changePassword(String userName, String password) {
        UserLoginExample example = new UserLoginExample();
        example.createCriteria().andUserNameEqualTo(userName);
        UserLogin userLogin = userLoginMapper.selectOneByExample(example);
        if (Objects.isNull(userLogin)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户不存在").build();
        }

        int result = userLoginMapper.updateByPrimaryKeySelective(UserLogin.builder().userId(userLogin.getUserId()).password(password).build());

        if (result != 1) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("修改失败").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("修改成功").build();
    }

    public BaseResponse logout(Integer id) {
        userLoginMapper.deleteByPrimaryKey(id);
        userInformationMapper.deleteByPrimaryKey(id);
        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode()).build();
    }
}
