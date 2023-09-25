 /*
  * Copyright © 2022 Yazaki Kako Corporation. All Rights Reserved
  */

 package com.celeth.springframework.core.io;

 import com.celeth.springframework.util.ClassUtils;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.io.InputStream;
 import org.springframework.util.Assert;

 /**
  * @author IBM陳玉体
  * @version 0.0.1
  * @since 2023/9/25 13:49
  */
 public class ClassPathResource implements Resource {

   private final String path;

   private ClassLoader classLoader;

   public ClassPathResource(String path) {
     this(path, (ClassLoader) null);
   }

   public ClassPathResource(String path, ClassLoader classLoader) {
     Assert.notNull(path, "Path must not be null");
     this.path = path;
     this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
   }

   @Override
   public InputStream getInputStream() throws IOException {
     InputStream is = classLoader.getResourceAsStream(path);
     if (is == null) {
       throw new FileNotFoundException(
           this.path + " cannot be opened because it does not exist");
     }
     return is;
   }
 }
