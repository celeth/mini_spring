 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import java.lang.reflect.Constructor;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 10:52
  */
 public interface InstantiationStrategy {
   Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor,
                      Object[] args) throws BeansException;
 }
