package com.fiction.service;

import com.fiction.BaseResponse;
import com.fiction.Enum.BaseCodeEnum;
import com.fiction.Enum.SqlType;
import com.fiction.Enum.UserTypeEnum;
import com.fiction.bean.bo.FocusUserBo;
import com.fiction.entity.UserFocusKey;
import com.fiction.entity.UserInformation;
import com.fiction.example.UserFocusExample;
import com.fiction.mapper.UserFocusMapper;
import com.fiction.mapper.UserInformationMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserFocusService {
    @Autowired
    UserFocusMapper userFocusMapper;

    @Autowired
    UserInformationMapper userInformationMapper;

    public BaseResponse getFocusAuthorInformation(Integer userId) {
        UserFocusExample example = new UserFocusExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserFocusKey> userFocuses = userFocusMapper.selectByExample(example);
        ArrayList<FocusUserBo> focusUserBoList = new ArrayList<>();
        for (UserFocusKey userFocus : userFocuses) {
            if (Objects.isNull(userFocus)) {
                return BaseResponse.builder()
                        .code(BaseCodeEnum.FAIL.getCode())
                        .Message("用户不存在").build();
            }

            UserInformation authorInformation = userInformationMapper.selectByPrimaryKey(userFocus.getAuthorId());

            if (Objects.nonNull(authorInformation) && Objects.equals(authorInformation.getType(), UserTypeEnum.WRITER.getCode())) {
                focusUserBoList.add(new FocusUserBo(authorInformation.getUserId(),
                        authorInformation.getUserName(), authorInformation.getSignature()));
            }
        }

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .body(focusUserBoList).build();
    }

    public BaseResponse deleteFollow(Integer userId, Integer followId) {
        UserFocusExample example = new UserFocusExample();
        example.createCriteria().andUserIdEqualTo(userId).andAuthorIdEqualTo(followId);
        LogUtils.log(SqlType.DELETE, "userfocus", "userId : " + userId + ", followId : " + followId);
        userFocusMapper.deleteByExample(example);
        return BaseResponse.builder().code(BaseCodeEnum.SUCCESS.getCode()).Message("取消关注成功").build();
    }

    public BaseResponse addFocus(Integer userId, Integer followId) {
        UserFocusExample userFocusExample = new UserFocusExample();
        userFocusExample.createCriteria().andUserIdEqualTo(userId).andAuthorIdEqualTo(followId);
        List<UserFocusKey> userFocusKeys = userFocusMapper.selectByExample(userFocusExample);

        if (userFocusKeys.size() != 0) {
            return BaseResponse.builder()
                    .code(BaseCodeEnum.FAIL.getCode())
                    .Message("关注失败").build();
        }

        UserFocusKey userFocusKey = UserFocusKey.builder().userId(userId).authorId(followId).build();
        LogUtils.log(SqlType.INSERT, "userfocus", String.valueOf(new JSONObject(userFocusKey)));
        userFocusMapper.insert(userFocusKey);

        return BaseResponse.builder()
                .code(BaseCodeEnum.SUCCESS.getCode())
                .Message("关注成功").build();
    }
}
