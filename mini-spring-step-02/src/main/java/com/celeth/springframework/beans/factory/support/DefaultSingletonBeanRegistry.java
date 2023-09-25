 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.factory.config.SingletonBeanRegistry;
 import java.util.HashMap;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 10:44
  */
 public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
   private HashMap<String, Object> singletonObjects = new HashMap();

   @Override
   public Object getSingleton(String beanName) {
     return singletonObjects.get(beanName);
   }

   protected void addSingleton(String beanName, Object bean) {
     singletonObjects.put(beanName, bean);
   }
 }
