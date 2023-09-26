 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.context.support;

 import com.celeth.springframework.beans.BeansException;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 16:22
  */
 public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {
   private String[] configLocations;

   public ClassPathXmlApplicationContext() {
   }

   /**
    * 从 XML 中加载 BeanDefinition，并刷新上下文
    *
    * @param configLocations
    * @throws BeansException
    */
   public ClassPathXmlApplicationContext(String configLocations) throws BeansException {
     this(new String[] {configLocations});
   }

   /**
    * 从 XML 中加载 BeanDefinition，并刷新上下文
    *
    * @param configLocations
    * @throws BeansException
    */
   public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
     this.configLocations = configLocations;
     refresh();
   }

   @Override
   protected String[] getConfigLocations() {
     return configLocations;
   }
 }
