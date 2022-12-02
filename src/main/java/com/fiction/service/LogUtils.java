package com.fiction.service;

import com.fiction.Enum.SqlType;
import com.fiction.FictionApplication;
import com.fiction.entity.Log;
import com.fiction.mapper.LogMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class LogUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间

    @Resource
    private LogMapper logMapper;
    private static LogUtils logUtils;

    @PostConstruct
    public void init() {
        logUtils = this;
        logUtils.logMapper = this.logMapper;
    }

    static {
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记
    }

    public static void log(SqlType sqlType, String tableName, String parameter) {
        Log log = Log.builder()
                .userId(FictionApplication.Uid)
                .type(sqlType.getMessage())
                .table(tableName)
                .parameter(parameter)
                .startdate(sdf.format(new Date())).build();
        logUtils.logMapper.insertSelective(log);
    }
}
