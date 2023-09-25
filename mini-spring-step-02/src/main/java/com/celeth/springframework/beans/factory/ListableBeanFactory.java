 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory;

 import com.celeth.springframework.beans.BeansException;
 import java.util.Map;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:57
  */
 public interface ListableBeanFactory extends BeanFactory {

   <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

   String[] getBeanDefinitionNames();
 }
