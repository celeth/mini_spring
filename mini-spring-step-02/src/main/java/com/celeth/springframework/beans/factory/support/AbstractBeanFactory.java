 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import com.celeth.springframework.beans.factory.config.BeanPostProcessor;
 import com.celeth.springframework.beans.factory.config.ConfigurableBeanFactory;
 import java.util.ArrayList;
 import java.util.List;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 10:46
  */
 public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements
     ConfigurableBeanFactory {

   private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<BeanPostProcessor>();

   @Override
   public Object getBean(String beanName) {
     return doGet(beanName, null);
   }

   @Override
   public Object getBean(String beanName, Object... args) {
     return doGet(beanName, args);
   }

   @Override
   public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
     return (T) getBean(name);
   }

   private <T> T doGet(String beanName, Object... args) {
     Object singleton = getSingleton(beanName);
     if (singleton != null) {
       return (T) singleton;
     }
     BeanDefinition beanDefinition = getBeanDefinition(beanName);
     return (T) createBean(beanName, beanDefinition, args);
   }

   protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

   protected abstract Object createBean(String beanName, BeanDefinition beanDefinition,
                                        Object... args)
       throws BeansException;

   @Override
   public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
     this.beanPostProcessors.remove(beanPostProcessor);
     this.beanPostProcessors.add(beanPostProcessor);
   }

   /**
    * Return the list of BeanPostProcessors that will get applied
    * to beans created with this factory.
    */
   public List<BeanPostProcessor> getBeanPostProcessors() {
     return this.beanPostProcessors;
   }
 }
