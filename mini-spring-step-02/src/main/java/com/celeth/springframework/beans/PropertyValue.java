 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:09
  */
 public class PropertyValue {
  private String name;
  private Object value;

  public PropertyValue(String name, Object value) {
   this.name = name;
   this.value = value;
  }

  public String getName() {
   return name;
  }

  public void setName(String name) {
   this.name = name;
  }

  public Object getValue() {
   return value;
  }

  public void setValue(Object value) {
   this.value = value;
  }
 }
