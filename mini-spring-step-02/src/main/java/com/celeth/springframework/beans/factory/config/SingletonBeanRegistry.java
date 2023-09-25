 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.config;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 10:41
  */
 public interface SingletonBeanRegistry {
   Object getSingleton(String beanName);
 }
