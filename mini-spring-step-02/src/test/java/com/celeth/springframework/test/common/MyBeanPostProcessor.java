package com.celeth.springframework.test.common;

import com.celeth.springframework.beans.BeansException;
import com.celeth.springframework.beans.factory.config.BeanPostProcessor;
import com.celeth.springframework.test.bean.UserService;

public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if ("userService".equals(beanName)) {
      UserService userService = (UserService) bean;
      userService.setLocation("change to : beijing");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }

}
