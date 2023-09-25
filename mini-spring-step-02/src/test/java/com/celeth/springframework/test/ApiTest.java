package com.celeth.springframework.test;


import com.celeth.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.celeth.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.celeth.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;


public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService =
            (UserService) beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }

}
