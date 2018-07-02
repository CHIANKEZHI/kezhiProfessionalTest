package com.service.testhelloworld.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.service.testhelloworld.dao.UserMapper;
import com.service.testhelloworld.entity.UserInfoBean;
import com.service.testhelloworld.redis.RedisServiceImpl;



@Component
public class TesthelloworldDelegate 
{
	private Logger logger = LoggerFactory.getLogger(TesthelloworldDelegate.class);
	
	@Autowired
    private UserMapper userMapper;
	
	@Autowired
	private RedisServiceImpl redisServiceImpl;
	
    public String helloworld(String name)
    {
    	logger.info("查询开始name=" + name);
    	
        // Do Some Magic Here!
        //return "Welcome, " + name;
    	UserInfoBean userInfo = userMapper.getUserInfoById(name);
    	
    	try
    	{
    		redisServiceImpl.set("111", "哈哈哈");
    	}
    	catch(Exception e)
    	{
    		logger.info(e.toString());
    	}
    	
    	
    	if(userInfo != null)
    	{
    		logger.info("查询结束name=" + name);
    		return userInfo.getfCusName();
    	}
    	else
    	{
    		logger.info("查询结束name=" + name);
    		return redisServiceImpl.get("111");
    	}
    	
    	
    }
}
