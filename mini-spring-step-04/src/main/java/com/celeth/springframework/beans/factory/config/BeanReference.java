 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.config;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 11:24
  */
 public class BeanReference {
   private final String beanName;

   public BeanReference(String beanName) {
     this.beanName = beanName;
   }

   public String getBeanName() {
     return beanName;
   }
 }
