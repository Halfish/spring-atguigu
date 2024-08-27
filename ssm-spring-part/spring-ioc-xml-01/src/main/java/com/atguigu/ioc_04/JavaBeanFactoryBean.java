package com.atguigu.ioc_04;

import org.springframework.beans.factory.FactoryBean;

public class JavaBeanFactoryBean implements FactoryBean<JavaBeanName> {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JavaBeanName getObject() throws Exception {
        return new JavaBeanName("Bruce");
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBeanName.class;
    }
}
