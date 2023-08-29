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
  * @since 2023/8/29 9:41
  */
 public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements
     BeanFactory {
   @Override
   public Object getBean(String name) throws BeansException {
     Object singleton = getSingleton(name);
     if (singleton != null) {
       return singleton;
     }
     BeanDefinition beanDefinition = getBeanDefinition(name);
     Object bean = createBean(name, beanDefinition);
     return bean;
   }

   protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

   protected abstract Object createBean(String beanName, BeanDefinition beanDefinition)
       throws BeansException;
 }
