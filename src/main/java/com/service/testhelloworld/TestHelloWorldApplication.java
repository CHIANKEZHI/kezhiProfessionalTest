package com.service.testhelloworld;

import java.io.IOException;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;
import org.apache.servicecomb.springboot.starter.provider.EnableServiceComb;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.service.testhelloworld.controller.TestMqClient;

@SpringBootApplication
@EnableServiceComb
@EnableAutoConfiguration
@MapperScan("com.service.testhelloworld.dao")
public class TestHelloWorldApplication extends SpringBootServletInitializer
{
	private static Logger logger = LoggerFactory.getLogger(TestHelloWorldApplication.class);
	
    public static void main(String[] args) throws Exception 
    {
    	//SpringApplication.run(TestHelloWorldApplication.class, args);
    	new SpringApplicationBuilder().sources(TestHelloWorldApplication.class).web(false).run(); //采用这种方式启动
        //initMq();
    	//test
    	// testwxx
    	//testtddd
    }
    
    public static void initMq()
    {
    	logger.info("##############initMq start!");
    	ConnectionFactory factory = new ConnectionFactory();
    	 //factory.setHost("192.168.1.185");
    	 //factory.setPort(5672);
    	 //factory.setUsername("dbUser");
    	 //factory.setPassword("kzUser");
    	 factory.setHost("127.0.0.1");
    	 factory.setPort(5672);
    	 factory.setUsername("guest");
    	 factory.setPassword("guest");
    	 
    	 try
    	 {
    		 Connection connection = factory.newConnection();
        	 Channel channel = connection.createChannel();

        	 channel.queueDeclare("test", false, false, false, null);
        	 logger.info(" [*] Waiting for messages. To exit press CTRL+C");

        	 Consumer consumer = new DefaultConsumer(channel)
        	 {
        	     @Override
        	     public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
        	             byte[] body)
        	             throws IOException
        	     {
        	         String message = new String(body, "UTF-8");
        	         logger.info(" [x] Received '" + message + "'");
        	     }
        	 };
        	 channel.basicConsume("test", true, consumer);
    	 }
    	 catch(Exception e)
    	 {
    		 logger.info(e.toString());
    	 }
    }
}
