package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

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

    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 方案一：直接调用方法；
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

//    @Bean
//    public JdbcTemplate jdbcTemplate2(DruidDataSource dataSource) {
//        // 方案二：直接作为函数形参
//        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        jdbcTemplate.setDataSource(dataSource);
//        return jdbcTemplate;
//    }
}
