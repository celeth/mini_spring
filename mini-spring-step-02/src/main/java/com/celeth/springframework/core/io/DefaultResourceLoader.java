 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.core.io;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:49
  */
 public class DefaultResourceLoader implements ResourceLoader {
   @Override
   public Resource getResource(String location) {
     return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
   }
 }
