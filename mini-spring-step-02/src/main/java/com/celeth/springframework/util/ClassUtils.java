 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.util;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:50
  */
 public class ClassUtils {
  public static ClassLoader getDefaultClassLoader() {
   ClassLoader cl = null;
   try {
    cl = Thread.currentThread().getContextClassLoader();
   }
   catch (Throwable ex) {
    // Cannot access thread context ClassLoader - falling back to system class loader...
   }
   if (cl == null) {
    // No thread context class loader -> use class loader of this class.
    cl = ClassUtils.class.getClassLoader();
   }
   return cl;
  }
 }
