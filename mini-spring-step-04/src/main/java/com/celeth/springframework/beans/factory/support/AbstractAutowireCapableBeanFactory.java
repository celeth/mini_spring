 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import cn.hutool.core.bean.BeanUtil;
 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.PropertyValue;
 import com.celeth.springframework.beans.PropertyValues;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import com.celeth.springframework.beans.factory.config.BeanReference;
 import java.lang.reflect.Constructor;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/8/29 9:44
  */
 public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
   private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

   @Override
   protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args)
       throws BeansException {
     Object bean = null;
     try {
       bean = createBeanInstance(beanDefinition, beanName, args);
       applyPropertyValues(beanName, bean, beanDefinition);
     } catch (Exception e) {
       throw new BeansException("Instantiation of bean failed", e);
     }
     addSingleton(beanName, bean);
     return bean;
   }

   protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
     try {
       PropertyValues propertyValues = beanDefinition.getPropertyValues();
       for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
         String name = propertyValue.getName();
         Object value = propertyValue.getValue();
         if (value instanceof BeanReference) {
           // A 依赖 B，获取 B 的实例化
           BeanReference beanReference = (BeanReference) value;
           value = getBean(beanReference.getBeanName());
         }
         // 属性填充
         BeanUtil.setFieldValue(bean, name, value);
       }
     } catch (Exception e) {
       throw new BeansException("Error setting property values：" + beanName);
     }
   }

   protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName,
                                       Object[] args) {
     Constructor constructorToUse = null;
     Class<?> beanClass = beanDefinition.getBeanClass();
     Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
     for (Constructor ctor : declaredConstructors) {
       if (null != args && ctor.getParameterTypes().length == args.length) {
         constructorToUse = ctor;
         break;
       }
     }
     return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse,
         args);
   }

   public InstantiationStrategy getInstantiationStrategy() {
     return instantiationStrategy;
   }

   public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
     this.instantiationStrategy = instantiationStrategy;
   }
 }
