package com.celeth.springframework.beans.factory.support;

import com.celeth.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
