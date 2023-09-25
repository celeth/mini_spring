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
  * @since 2023/9/25 10:46
  */
 public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements
     BeanFactory {
   @Override
   public Object getBean(String beanName) {
     return getBean(beanName, null);
   }

   @Override
   public Object getBean(String beanName, Object... args) {
     return doGet(beanName, args);
   }

   private <T> T doGet(String beanName, Object... args) {
     Object singleton = getSingleton(beanName);
     if (singleton != null) {
       return (T) singleton;
     }
     BeanDefinition beanDefinition = getBeanDefinition(beanName);
     return (T) createBean(beanName, beanDefinition, args);
   }

   protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

   protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,
                                        Object... args)
       throws BeansException;
 }
