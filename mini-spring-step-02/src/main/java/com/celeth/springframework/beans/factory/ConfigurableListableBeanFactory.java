 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.AutowireCapableBeanFactory;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import com.celeth.springframework.beans.factory.config.ConfigurableBeanFactory;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:56
  */
 public interface ConfigurableListableBeanFactory extends ConfigurableBeanFactory,ListableBeanFactory,
     AutowireCapableBeanFactory {
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;
 }
