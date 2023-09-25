 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.core.io;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:50
  */
 public interface ResourceLoader {
   String CLASSPATH_URL_PREFIX = "classpath:";
   Resource getResource(String location);
 }
