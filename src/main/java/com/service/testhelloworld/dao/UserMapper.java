package com.service.testhelloworld.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.service.testhelloworld.entity.UserInfoBean;

@Mapper
public interface UserMapper 
{
    UserInfoBean getUserInfoById(@Param(value = "userCode")
    String userCode); 
}
