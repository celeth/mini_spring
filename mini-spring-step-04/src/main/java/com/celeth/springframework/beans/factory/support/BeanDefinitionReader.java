package com.celeth.springframework.beans.factory.support;

import com.celeth.springframework.beans.BeansException;
import com.celeth.springframework.core.io.Resource;
import com.celeth.springframework.core.io.ResourceLoader;

/**
 * Simple interface for bean definition readers.
 *
 *
 *
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
