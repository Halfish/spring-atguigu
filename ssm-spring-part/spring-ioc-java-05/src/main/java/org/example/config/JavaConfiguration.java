package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.xml.crypto.Data;

/*
 * Java配置类，替代xml
 *  1. 包扫描注解配置
 *  2. 引用外部的配置文件
 *  3. 声明第三方依赖的 bean组件
 */
@ComponentScan("org.example.ioc_01")
@PropertySource("classpath:jdbc.properties")
@Configuration
public class JavaConfiguration {

    @Value("${atguigu.url}")
    private String url;

    @Value("${atguigu.driver}")
    private String driver;

    @Value("${atguigu.username}")
    private String username;

    @Value("${atguigu.password}")
    private String password;

    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
