package com.celeth.springframework.beans.factory;

import com.celeth.springframework.beans.BeansException;

public interface BeanFactory {
  Object getBean(String beanName);

  Object getBean(String beanName, Object... args);
  <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
