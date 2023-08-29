 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 11:25
  */
 public class PropertyValue {
   private final String name;

   private final Object value;

   public PropertyValue(String name, Object value) {
     this.name = name;
     this.value = value;
   }

   public String getName() {
     return name;
   }

   public Object getValue() {
     return value;
   }
 }
