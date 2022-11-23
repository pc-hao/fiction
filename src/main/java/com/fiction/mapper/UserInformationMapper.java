package com.fiction.mapper;

import com.fiction.entity.UserInformation;
import com.fiction.example.UserInformationExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface UserInformationMapper {
    long countByExample(UserInformationExample example);

    int deleteByExample(UserInformationExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInformation record);

    int insertSelective(UserInformation record);

    List<UserInformation> selectByExampleWithRowbounds(UserInformationExample example, RowBounds rowBounds);

    List<UserInformation> selectByExample(UserInformationExample example);

    UserInformation selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserInformation record, @Param("example") UserInformationExample example);

    int updateByExample(@Param("record") UserInformation record, @Param("example") UserInformationExample example);

    int updateByPrimaryKeySelective(UserInformation record);

    int updateByPrimaryKey(UserInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table userinformation
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    UserInformation selectOneByExample(UserInformationExample example);

    List<UserInformation> selectByName(@Param("userName")String userName);
}