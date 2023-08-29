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
 public interface BeanDefinitionRegistry {
  /**
   * 向注册表中注册 BeanDefinition
   *
   * @param beanName
   * @param beanDefinition
   */
  void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

  /**
   * 使用Bean名称查询BeanDefinition
   *
   * @param beanName
   * @return
   * @throws BeansException
   */
  BeanDefinition getBeanDefinition(String beanName) throws BeansException;

  /**
   * 判断是否包含指定名称的BeanDefinition
   * @param beanName
   * @return
   */
  boolean containsBeanDefinition(String beanName);

  /**
   * Return the names of all beans defined in this registry.
   *
   * 返回注册表中所有的Bean名称
   */
  String[] getBeanDefinitionNames();
 }
