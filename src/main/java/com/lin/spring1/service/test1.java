package com.lin.spring1.service;

import com.lin.spring1.model.Business;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

public class test1 {

    public void function() {
//        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
//        AbstractBeanDefinition beanDefinition = new RootBeanDefinition(Business.class);
//        beanRegistry.registerBeanDefinition("beanDefinition", beanDefinition);
//        BeanFactory container = beanRegistry;
//
//        Business business = (Business) container.getBean("beanDefinition");
//        business.function();

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition definition = new RootBeanDefinition(Business.class);
        beanFactory.registerBeanDefinition("a",definition);
       Business business1 = (Business) beanFactory.getBean("a");
       business1.function();

    }

    public void function2(){
        ClassPathResource classPathResource = new ClassPathResource("beans.xml");
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(classPathResource);

    }

    public void function3(){
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext();
    }

    public static void main1() {
        List<Integer> a = new ArrayList<>();
        List<IdName> result = new ArrayList<>();
        a.stream().collect(Collectors.toMap(Integer::valueOf,o->o));
    }

    public static void main(String[] args) {
        new test1().function();
    }

    private <T> Collection<T> getSpringFactoriesInstances(Class<T> type, Class<?>[] parameterTypes, Object... args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Set<String> names = new LinkedHashSet(SpringFactoriesLoader.loadFactoryNames(type, classLoader));

        List<T> instances = createSpringFactoriesInstances(type, parameterTypes, classLoader, args, names);
        AnnotationAwareOrderComparator.sort(instances);
        return instances;
    }

    private <T> Collection<T> get(Class<T> type, Class<?>[] parameterTypes, Object... args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return null;
    }

    private <T> List<T> createSpringFactoriesInstances(Class<T> type, Class<?>[] parameterTypes, ClassLoader classLoader, Object[] args, Set<String> names) {
        List<T> instances = new ArrayList(names.size());
        Iterator var7 = names.iterator();

        while (var7.hasNext()) {
            String name = (String) var7.next();

            try {
                Class<?> instanceClass = ClassUtils.forName(name, classLoader);
                Assert.isAssignable(type, instanceClass);
                Constructor<?> constructor = instanceClass.getDeclaredConstructor(parameterTypes);
                Object instance = BeanUtils.instantiateClass(constructor, args);
                instances.add((T) instance);
            } catch (Throwable var12) {
                throw new IllegalArgumentException("Cannot instantiate " + type + " : " + name, var12);
            }
        }

        return instances;
    }

}
