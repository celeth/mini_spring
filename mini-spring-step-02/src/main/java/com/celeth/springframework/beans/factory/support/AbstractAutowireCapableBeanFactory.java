 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import cn.hutool.core.bean.BeanUtil;
 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.PropertyValue;
 import com.celeth.springframework.beans.PropertyValues;
 import com.celeth.springframework.beans.factory.config.AutowireCapableBeanFactory;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import com.celeth.springframework.beans.factory.config.BeanPostProcessor;
 import com.celeth.springframework.beans.factory.config.BeanReference;
 import java.lang.reflect.Constructor;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 10:58
  */
 public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements
     AutowireCapableBeanFactory {
   private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

   @Override
   protected Object createBean(String beanName, BeanDefinition beanDefinition, Object... args)
       throws BeansException {
     Object bean = null;
     try {
       bean = createBeanInstance(beanName, beanDefinition, args);
       applyPropertyValues(beanName, bean, beanDefinition);
       // 执行 Bean 的初始化方法和 BeanPostProcessor 的前置和后置处理方法
       bean = initializeBean(beanName, bean, beanDefinition);
     } catch (Exception e) {
       throw new BeansException("bean init failed.");
     }
     addSingleton(beanName, bean);
     return bean;
   }

   private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
     // 1. 执行 BeanPostProcessor Before 处理
     Object wrappedBean = applyBeanPostProcessorsBeforeInitialization(bean, beanName);

     // 待完成内容：invokeInitMethods(beanName, wrappedBean, beanDefinition);
     invokeInitMethods(beanName, wrappedBean, beanDefinition);

     // 2. 执行 BeanPostProcessor After 处理
     wrappedBean = applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
     return wrappedBean;
   }

   private void invokeInitMethods(String beanName, Object wrappedBean,
                                  BeanDefinition beanDefinition) {
   }

   private void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
     try {
       PropertyValues propertyValues = beanDefinition.getPropertyValues();
       if (propertyValues != null) {
         for (PropertyValue p : propertyValues.getPropertyValues()) {
           String name = p.getName();
           Object value = p.getValue();
           if (value instanceof BeanReference) {
             BeanReference beanReference = (BeanReference) value;
             value = getBean(beanReference.getBeanName());
           }
           BeanUtil.setFieldValue(bean, name, value);
         }
       }
     } catch (Exception e) {
       throw new BeansException("reference failed.");
     }
   }

   private Object createBeanInstance(String beanName, BeanDefinition beanDefinition,
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

   public void setInstantiationStrategy(
       InstantiationStrategy instantiationStrategy) {
     this.instantiationStrategy = instantiationStrategy;
   }

   @Override
   public Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
       throws BeansException {
     Object result = existingBean;
     for (BeanPostProcessor processor : getBeanPostProcessors()) {
       Object current = processor.postProcessBeforeInitialization(result, beanName);
       if (null == current) {
         return result;
       }
       result = current;
     }
     return result;
   }

   @Override
   public Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
       throws BeansException {
     Object result = existingBean;
     for (BeanPostProcessor processor : getBeanPostProcessors()) {
       Object current = processor.postProcessAfterInitialization(result, beanName);
       if (null == current) {
         return result;
       }
       result = current;
     }
     return result;
   }
 }
