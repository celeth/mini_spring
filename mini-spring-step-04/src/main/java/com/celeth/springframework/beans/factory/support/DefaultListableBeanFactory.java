 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 9:44
  */
 public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
     implements BeanDefinitionRegistry {
   private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

   @Override
   protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
     BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
    if (beanDefinition == null) {
     throw new BeansException("No bean named '" + beanName + "' is defined");
    }
     return beanDefinition;
   }

   @Override
   public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
     beanDefinitionMap.put(beanName, beanDefinition);
   }
 }