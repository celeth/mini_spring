 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 9:44
  */
 public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
   @Override
   protected Object createBean(String beanName, BeanDefinition beanDefinition)
       throws BeansException {
     Object bean = null;
     try {
       bean = beanDefinition.getBeanClass().newInstance();
     } catch (InstantiationException e) {
       throw new RuntimeException(e);
     } catch (IllegalAccessException e) {
       throw new RuntimeException(e);
     }
     addSingleton(beanName, bean);
     return bean;
   }
 }
