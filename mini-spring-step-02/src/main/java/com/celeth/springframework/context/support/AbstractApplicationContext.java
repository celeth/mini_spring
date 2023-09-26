 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.context.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.ConfigurableListableBeanFactory;
 import com.celeth.springframework.beans.factory.config.BeanFactoryPostProcessor;
 import com.celeth.springframework.beans.factory.config.BeanPostProcessor;
 import com.celeth.springframework.context.ConfigurableApplicationContext;
 import com.celeth.springframework.core.io.DefaultResourceLoader;
 import java.util.Map;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 16:22
  */
 public abstract class AbstractApplicationContext extends DefaultResourceLoader implements
     ConfigurableApplicationContext {
   @Override
   public void refresh() throws BeansException {
     // 1. 创建 BeanFactory，并加载 BeanDefinition
     refreshBeanFactory();

     // 2. 获取 BeanFactory
     ConfigurableListableBeanFactory beanFactory = getBeanFactory();

     // 3. 在 Bean 实例化之前，执行 BeanFactoryPostProcessor (Invoke factory processors registered as beans in the context.)
     invokeBeanFactoryPostProcessors(beanFactory);

     // 4. BeanPostProcessor 需要提前于其他 Bean 对象实例化之前执行注册操作
     registerBeanPostProcessors(beanFactory);

     // 5. 提前实例化单例Bean对象
     beanFactory.preInstantiateSingletons();
   }

   protected abstract void refreshBeanFactory() throws BeansException;

   protected abstract ConfigurableListableBeanFactory getBeanFactory();

   private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
     Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap =
         beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
     for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
       beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
     }
   }

   private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
     Map<String, BeanPostProcessor> beanPostProcessorMap =
         beanFactory.getBeansOfType(BeanPostProcessor.class);
     for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
       beanFactory.addBeanPostProcessor(beanPostProcessor);
     }
   }

   @Override
   public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
     return getBeanFactory().getBeansOfType(type);
   }

   @Override
   public String[] getBeanDefinitionNames() {
     return getBeanFactory().getBeanDefinitionNames();
   }

   @Override
   public Object getBean(String name) throws BeansException {
     return getBeanFactory().getBean(name);
   }

   @Override
   public Object getBean(String name, Object... args) throws BeansException {
     return getBeanFactory().getBean(name, args);
   }

   @Override
   public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
     return getBeanFactory().getBean(name, requiredType);
   }
 }
