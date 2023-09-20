package com.celeth.springframework.beans.factory.support;

import com.celeth.springframework.beans.factory.config.SingletonBeanRegistry;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
  private ConcurrentHashMap<String, Object> singletonObjects =
      new ConcurrentHashMap<>();

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }

  protected void addSingleton(String beanName, Object singletonObject) {
    singletonObjects.put(beanName, singletonObject);
  }
}
