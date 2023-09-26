 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.context.support;

 import com.celeth.springframework.beans.factory.support.DefaultListableBeanFactory;
 import com.celeth.springframework.beans.factory.xml.XmlBeanDefinitionReader;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 16:22
  */
 public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
  @Override
  protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
   XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
   String[] configLocations = getConfigLocations();
   if (null != configLocations){
    beanDefinitionReader.loadBeanDefinitions(configLocations);
   }
  }

  protected abstract String[] getConfigLocations();
 }
