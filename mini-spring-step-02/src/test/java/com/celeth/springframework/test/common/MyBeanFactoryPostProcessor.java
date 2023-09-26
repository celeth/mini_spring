package com.celeth.springframework.test.common;

import com.celeth.springframework.beans.BeansException;
import com.celeth.springframework.beans.PropertyValue;
import com.celeth.springframework.beans.PropertyValues;
import com.celeth.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.celeth.springframework.beans.factory.config.BeanDefinition;
import com.celeth.springframework.beans.factory.config.BeanFactoryPostProcessor;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
      throws BeansException {

    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
    PropertyValues propertyValues = beanDefinition.getPropertyValues();

    propertyValues.addPropertyValue(new PropertyValue("company", "changeto : zijie"));
  }

}
