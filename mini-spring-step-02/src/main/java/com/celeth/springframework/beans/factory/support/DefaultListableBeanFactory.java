 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.beans.BeansException;
 import com.celeth.springframework.beans.factory.ConfigurableListableBeanFactory;
 import com.celeth.springframework.beans.factory.config.BeanDefinition;
 import java.util.HashMap;
 import java.util.Map;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 11:00
  */
 public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements
     BeanDefinitionRegistry, ConfigurableListableBeanFactory {
   private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

   @Override
   public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
     beanDefinitionMap.put(beanName, beanDefinition);
   }

   @Override
   public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
     BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
     if (beanDefinition == null) {
       throw new BeansException("bean has not registered.");
     }
     return beanDefinition;
   }

   @Override
   public boolean containsBeanDefinition(String beanName) {
     return beanDefinitionMap.containsKey(beanName);
   }

   @Override
   public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
     Map<String, T> result = new HashMap<>();
     beanDefinitionMap.forEach((beanName, beanDefinition) -> {
       Class beanClass = beanDefinition.getBeanClass();
       if (type.isAssignableFrom(beanClass)) {
         result.put(beanName, (T) getBean(beanName));
       }
     });
     return result;
   }

   @Override
   public String[] getBeanDefinitionNames() {
     return beanDefinitionMap.keySet().toArray(new String[0]);
   }
 }
