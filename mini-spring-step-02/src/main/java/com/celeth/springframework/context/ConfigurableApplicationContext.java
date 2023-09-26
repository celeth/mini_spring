 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.context;

 import com.celeth.springframework.beans.BeansException;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 16:21
  */
 public interface ConfigurableApplicationContext extends ApplicationContext {
   void refresh() throws BeansException;
 }
