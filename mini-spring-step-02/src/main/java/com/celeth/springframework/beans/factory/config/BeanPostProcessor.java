package com.celeth.springframework.beans.factory.config;

import com.celeth.springframework.beans.BeansException;

public interface BeanPostProcessor {
  /**
   * 在 Bean 对象执行初始化方法之前，执行此方法 * * @param bean * @param beanName * @return * @throws BeansException
   */
  Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

  Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
