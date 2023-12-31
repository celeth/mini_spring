 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import java.lang.reflect.Constructor;
 import java.lang.reflect.InvocationTargetException;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 11:13
  */
 public class SimpleInstantiationStrategy implements InstantiationStrategy {
   @Override
   public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,
                             Object[] args) throws BeansException {
     Class clazz = beanDefinition.getBeanClass();
     try {
       if (null != ctor) {
         return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
       } else {
         return clazz.getDeclaredConstructor().newInstance();
       }
     } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
              InvocationTargetException e) {
       throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
     }
   }
 }
