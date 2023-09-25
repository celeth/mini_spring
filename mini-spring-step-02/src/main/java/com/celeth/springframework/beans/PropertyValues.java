 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans;

 import java.util.ArrayList;
 import java.util.List;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:10
  */
 public class PropertyValues {
   private List<PropertyValue> propertyValueList = new ArrayList<>();

   public void addPropertyValue(PropertyValue propertyValue) {
     this.propertyValueList.add(propertyValue);
   }

   public PropertyValue[] getPropertyValues() {
     return this.propertyValueList.toArray(new PropertyValue[0]);
   }

   public PropertyValue getPropertyValue(String propertyName) {
     for (PropertyValue pv : this.propertyValueList) {
       if (pv.getName().equals(propertyName)) {
         return pv;
       }
     }
     return null;
   }
 }
