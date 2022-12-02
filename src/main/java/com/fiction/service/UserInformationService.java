package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.Enum.SqlType;
import com.fiction.bean.bo.UserInformationBo;
import com.fiction.entity.UserInformation;
import com.fiction.example.UserInformationExample;
import com.fiction.mapper.UserInformationMapper;
import org.json.JSONObject;
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
                .body(UserInformationBo.builder()
                        .userId(userInformation.getUserId())
                        .userName(userInformation.getUserName())
                        .userSex(userInformation.getSex())
                        .userEmail(userInformation.getEmail())
                        .userNation(userInformation.getNational())
                        .userSentence(userInformation.getSignature()).build()
                ).build();
    }

    public BaseResponse update(UserInformationBo userInformationBo) {
        UserInformationExample example = new UserInformationExample();
        example.createCriteria().andUserIdEqualTo(userInformationBo.getUserId());
        UserInformation userInformation = userInformationMapper.selectOneByExample(example);
        if (Objects.isNull(userInformation)) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户不存在").build();
        }

        UserInformation userInformation1 = UserInformation.builder()
                .userName(userInformationBo.getUserName())
                .sex(userInformationBo.getUserSex())
                .national(userInformationBo.getUserNation())
                .signature(userInformationBo.getUserSentence())
                .email(userInformationBo.getUserEmail())
                .build();
        LogUtils.log(SqlType.UPDATE, "userinformation", String.valueOf(new JSONObject(userInformation1)));

        int tmp = userInformationMapper.updateByExampleSelective(userInformation1, example);

        if (tmp == 0) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("用户信息修改失败").build();
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("用户信息修改成功").build();
    }
}
