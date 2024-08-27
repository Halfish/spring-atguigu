package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewJavaBean {
    @Value("${jdbc.username}")
    public String username;

    @Value("${jdbc.password}")
    public String password;

    @Override
    public String toString() {
        return "NewJavaBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
