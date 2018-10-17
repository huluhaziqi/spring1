package com.lin.spring1.service;

import com.lin.spring1.bean.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;

public class MyService implements InitializingBean, ApplicationContextAware,
        ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, EnvironmentAware, ImportAware, ResourceLoaderAware {

    @Override
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        System.out.println("setApplicationContext called");
        System.out.println("setApplicationContext:: Bean Definition Names="
                + Arrays.toString(ctx.getBeanDefinitionNames()));
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setBeanName called");
        System.out.println("setBeanName:: Bean Name defined in context="
                + beanName);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader called");
        System.out.println("setBeanClassLoader:: ClassLoader Name="
                + classLoader.getClass().getName());
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader called");
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        System.out.println("setResourceLoader:: Resource File Name="
                + resource.getFilename());
    }

    @Override
    public void setImportMetadata(AnnotationMetadata annotationMetadata) {
        System.out.println("setImportMetadata called");
    }

    @Override
    public void setEnvironment(Environment env) {
        System.out.println("setEnvironment called");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory called");
        System.out.println("setBeanFactory:: employee bean singleton=");
//                + beanFactory.isSingleton("employee"));
    }

    @Override
    public void setApplicationEventPublisher(
            ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher called");
    }


    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public MyService(Employee employee) {
        this.employee = employee;
    }


    @PostConstruct
    public void init() {
        System.out.println("MyService init method called");
    }

    public MyService() {
        System.out.println("MyService no-args constructor called");
    }

    @PreDestroy
    public void destory() {
        System.out.println("MyService destroy method called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init myservice");
//        if(employee.getName() == null){
//            employee.setName("myServiceEmployee");
//        }
    }
}
