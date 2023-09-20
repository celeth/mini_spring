 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.test;

 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import com.celeth.springframework.beans.factory.support.DefaultListableBeanFactory;
 import com.celeth.springframework.test.bean.UserService;
 import org.junit.jupiter.api.Test;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 10:08
  */
 public class ApiTest {
   @Test
   public void test_BeanFactory() {
     // 1.初始化 BeanFactory
     DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
     // 2.注册 bean
     BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
     beanFactory.registerBeanDefinition("userService", beanDefinition);
     // 3.第一次获取 bean
     UserService userService = (UserService) beanFactory.getBean("userService","test1");
     userService.queryUserInfo();
     // 4.第二次获取 bean from Singleton
     UserService userService_singleton = (UserService) beanFactory.getBean("userService","tes2");
     userService_singleton.queryUserInfo();
   }
 }
