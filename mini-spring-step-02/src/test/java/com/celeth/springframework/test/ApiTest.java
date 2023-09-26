package com.celeth.springframework.test;


import com.celeth.springframework.context.support.ClassPathXmlApplicationContext;
import com.celeth.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;


public class ApiTest {

  @Test
  public void test_BeanFactory() {
    // 1.初始化 BeanFactory
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

    // 2. 获取Bean对象调用方法
    UserService userService = applicationContext.getBean("userService", UserService.class);
    String result = userService.queryUserInfo();
    System.out.println("test result: " + result);
  }

}
