package com.service.testhelloworld.controller;



import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.service.testhelloworld.entity.UserInfoBean;



@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-05-23T07:05:35.012Z")

@RestSchema(schemaId = "testmq")
@RequestMapping(path = "/testHelloWorld", produces = MediaType.APPLICATION_JSON)
public class TestMqClient 
{
	private Logger logger = LoggerFactory.getLogger(TestMqClient.class);
	
	@Autowired
    private AmqpTemplate template;
	
    @RequestMapping(value = "/testMq",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public void helloworld( @RequestParam(value = "message", required = true) String message)
    {

//    	ConnectionFactory factory = new ConnectionFactory();
////    	 factory.setHost("192.168.1.185");
////    	 factory.setPort(5672);
////    	 factory.setUsername("dbUser");
////    	 factory.setPassword("kzUser");
//    	factory.setHost("127.0.0.1");
//   	    factory.setPort(5672);
//   	    factory.setUsername("guest");
//   	    factory.setPassword("guest");
//    	 
//    	 Channel channel = null;
//    	 Connection connection = null;
//    	 
//    	 try
//    	 {
//    		 connection = factory.newConnection();
//        	 channel = connection.createChannel();
//
//        	 channel.queueDeclare("test", false, false, false, null);
//        	 //String message = "Hello World!";
//        	 channel.basicPublish("", "", null, message.getBytes("UTF-8"));
//        	 logger.info(" [x] Sent  '" + message + "'");
//    	 }
//    	 catch(Exception e)
//    	 {
//    		 logger.info("调用mq失败！ " + e.toString());
//    	 }
//    	 finally
//    	 {
//    		 
//    		 try
//    		 {
//    			 channel.close();
//				 connection.close();
//			 } 
//    		 catch (Exception e)
//    		 {
//				logger.info(e.toString());
//			 }
//    	 }
        
    	UserInfoBean userInfo = new UserInfoBean();
    	userInfo.setfCusCode(message);
    	userInfo.setfCusName("董大锤");
    	userInfo.setfPhone("15898909897");
    	
        template.convertAndSend("queue",userInfo);
        
        logger.info(" [x] Sent  '" + userInfo + "'");
    }

}
