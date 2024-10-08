package com.atguigu.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)     // 单例模式
public class JavaBean {

    @PostConstruct
    public void init() {
        System.out.println("JavaBean.init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JavaBean.destroy");
    }
}
