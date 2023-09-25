package com.celeth.springframework.test;


import com.celeth.springframework.beans.PropertyValue;
import com.celeth.springframework.beans.PropertyValues;
import com.celeth.springframework.beans.factory.config.BeanDefinition;
import com.celeth.springframework.beans.factory.config.BeanReference;
import com.celeth.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.celeth.springframework.test.bean.UserDao;
import com.celeth.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserDao.class);
        beanFactory.registerBeanDefinition("userDao",beanDefinition);
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));
        BeanDefinition beanDefinition1 = new BeanDefinition(UserService.class,propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition1);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
