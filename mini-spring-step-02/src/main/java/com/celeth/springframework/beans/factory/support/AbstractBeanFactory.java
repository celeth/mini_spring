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
     Object singleton = getSingleton(name);
     if (singleton != null) {
       return singleton;
     }
     BeanDefinition beanDefination = getBeanDefinition(name);
     return createBean(name, beanDefination);
   }

   protected abstract Object createBean(String name, BeanDefinition beanDefination);

   protected abstract BeanDefinition getBeanDefinition(String name);


 }
