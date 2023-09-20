 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import java.lang.reflect.Constructor;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/20 15:14
  */
 public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
   private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

   @Override
   protected Object createBean(String name, BeanDefinition beanDefination, Object[] args) {
     Object bean;
     try {
       bean = createBeanInstance(beanDefination, name, args);
     } catch (Exception e) {
       throw new BeansException("Instantiation of bean failed", e);
     }
     addSingleton(name, bean);
     return bean;
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

   public void setInstantiationStrategy(
       InstantiationStrategy instantiationStrategy) {
     this.instantiationStrategy = instantiationStrategy;
   }
 }
