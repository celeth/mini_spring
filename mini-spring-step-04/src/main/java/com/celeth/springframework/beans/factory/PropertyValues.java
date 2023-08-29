 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory;

 import java.util.ArrayList;
 import java.util.List;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 11:25
  */
 public class PropertyValues {
   private final List<PropertyValue> propertyValueList = new ArrayList<>();

   public void addPropertyValue(PropertyValue pv) {
     this.propertyValueList.add(pv);
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
