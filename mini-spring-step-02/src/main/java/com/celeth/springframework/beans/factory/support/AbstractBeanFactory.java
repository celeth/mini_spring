 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.BeanFactory;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/20 15:09
  */
 public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements
     BeanFactory {

   @Override
   public Object getBean(String name) throws BeansException {
     return doGetBean(name, null);
   }

   @Override
   public Object getBean(String name, Object... args) throws BeansException {
     return doGetBean(name, args);
   }

   protected <T> T doGetBean(final String name, final Object[] args) {
     Object bean = getSingleton(name);
     if (bean != null) {
       return (T) bean;
     }

     BeanDefinition beanDefinition = getBeanDefinition(name);
     return (T) createBean(name, beanDefinition, args);
   }

   protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,
                                        Object[] args) throws BeansException;

   protected abstract BeanDefinition getBeanDefinition(String name);

 }
