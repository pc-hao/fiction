package com.fiction.service;

import com.fiction.entity.UserInformation;
import com.fiction.mapper.UserInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fiction.example.UserInformationExample;
import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.bean.bo.UserInforBo;
import com.fiction.entity.User;
import com.fiction.example.UserInformationExample;
import com.fiction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserInformationService {
    @Autowired
    UserInformationMapper userInformationMapper;

    public BaseResponse getAllInformation(Integer userId) {
        UserInformationExample example = new UserInformationExample();
        example.createCriteria().andUserIdEqualTo(userId);
        UserInformation userInformation = userInformationMapper.selectOneByExample(example);
        if (Objects.isNull(userInformation)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户不存在").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(new UserInforBo(
                        userInformation.getUserId(),
                        userInformation.getPassword(),
                        userInformation.getSex(),
                        userInformation.getEmail(),
                        userInformation.getNational(),
                        userInformation.getSignature()
                )).build();
    }
}
