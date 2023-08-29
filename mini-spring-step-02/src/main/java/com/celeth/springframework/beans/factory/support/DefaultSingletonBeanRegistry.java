 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.factory.config.SingletonBeanRegistry;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 9:42
  */
 public abstract class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
   private Map<String, Object> singletonObjects = new HashMap<>();

   public Object getSingleton(String beanName) {
     return singletonObjects.get(beanName);
   }

   public void addSingleton(String beanName, Object singletonObject) {
     singletonObjects.put(beanName, singletonObject);
   }
 }
