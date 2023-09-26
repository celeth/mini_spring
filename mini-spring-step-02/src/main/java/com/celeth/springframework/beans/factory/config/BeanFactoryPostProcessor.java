package com.celeth.springframework.beans.factory.config;

import com.celeth.springframework.beans.BeansException;
import com.celeth.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {
  void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
