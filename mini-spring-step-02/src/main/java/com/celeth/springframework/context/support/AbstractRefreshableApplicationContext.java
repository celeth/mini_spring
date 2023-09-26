 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.context.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.ConfigurableListableBeanFactory;
 import com.celeth.springframework.beans.factory.support.DefaultListableBeanFactory;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 16:22
  */
 public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
   private DefaultListableBeanFactory beanFactory;

   @Override
   protected void refreshBeanFactory() throws BeansException {
     DefaultListableBeanFactory beanFactory = createBeanFactory();
     loadBeanDefinitions(beanFactory);
     this.beanFactory = beanFactory;
   }

   private DefaultListableBeanFactory createBeanFactory() {
     return new DefaultListableBeanFactory();
   }

   protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

   @Override
   protected ConfigurableListableBeanFactory getBeanFactory() {
     return beanFactory;
   }
 }
