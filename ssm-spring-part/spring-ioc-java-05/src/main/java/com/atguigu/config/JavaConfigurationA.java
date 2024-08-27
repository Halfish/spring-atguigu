package com.atguigu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(value = JavaConfiguration.class)
@Configuration
public class JavaConfigurationA {
}
