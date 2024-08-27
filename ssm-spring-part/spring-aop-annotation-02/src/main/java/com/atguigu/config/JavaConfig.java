package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.atguigu")
@EnableAspectJAutoProxy     // 开启aspectj注解
public class JavaConfig {
}
