 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.config;

 import com.celeth.springframework.beans.PropertyValues;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 10:41
  */
 public class BeanDefinition {
   private Class beanClass;

   private PropertyValues propertyValues;

   public BeanDefinition(Class beanClass) {
     this.beanClass = beanClass;
     this.propertyValues = new PropertyValues();
   }

   public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
     this.beanClass = beanClass;
     this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
   }

   public Class getBeanClass() {
     return beanClass;
   }

   public void setBeanClass(Class beanClass) {
     this.beanClass = beanClass;
   }

   public PropertyValues getPropertyValues() {
     return propertyValues;
   }

   public void setPropertyValues(PropertyValues propertyValues) {
     this.propertyValues = propertyValues;
   }
 }
