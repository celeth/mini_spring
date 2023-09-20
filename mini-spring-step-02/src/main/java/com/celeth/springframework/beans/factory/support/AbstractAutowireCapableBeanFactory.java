 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/20 15:14
  */
 public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
   @Override
   protected Object createBean(String name, BeanDefinition beanDefination) {
     Object bean;
     Class beanClass = beanDefination.getBeanClass();
     try {
       bean = beanClass.newInstance();
     } catch (InstantiationException | IllegalAccessException e) {
       throw new BeansException("Instantiation of bean failed", e);
     }
     addSingleton(name, bean);
     return bean;
   }
 }
