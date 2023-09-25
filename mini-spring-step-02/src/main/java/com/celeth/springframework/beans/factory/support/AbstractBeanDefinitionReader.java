 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.beans.factory.support;

 import com.celeth.springframework.core.io.DefaultResourceLoader;
 import com.celeth.springframework.core.io.ResourceLoader;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:53
  */
 public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
   private final BeanDefinitionRegistry registry;

   private ResourceLoader resourceLoader;

   protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
     this(registry, new DefaultResourceLoader());
   }

   public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry,
                                       ResourceLoader resourceLoader) {
     this.registry = registry;
     this.resourceLoader = resourceLoader;
   }

   @Override
   public BeanDefinitionRegistry getRegistry() {
     return registry;
   }

   @Override
   public ResourceLoader getResourceLoader() {
     return resourceLoader;
   }
 }
