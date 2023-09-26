package com.celeth.springframework.beans.factory.config;

import com.celeth.springframework.beans.factory.HierarchicalBeanFactory;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
  String SCOPE_SINGLETON = "singleton";

  String SCOPE_PROTOTYPE = "prototype";

  void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
