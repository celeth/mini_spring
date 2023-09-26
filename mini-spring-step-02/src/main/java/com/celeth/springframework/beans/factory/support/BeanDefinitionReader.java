 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.core.io.Resource;
 import com.celeth.springframework.core.io.ResourceLoader;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:53
  */
 public interface BeanDefinitionReader {
   BeanDefinitionRegistry getRegistry();

   ResourceLoader getResourceLoader();

   void loadBeanDefinitions(Resource resource) throws BeansException;

   void loadBeanDefinitions(Resource... resources) throws BeansException;

   void loadBeanDefinitions(String location) throws BeansException;
   void loadBeanDefinitions(String... locations) throws BeansException;
 }
