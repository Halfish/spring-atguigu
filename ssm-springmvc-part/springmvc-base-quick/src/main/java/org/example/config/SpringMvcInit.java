package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * 可以被 web 项目加载，初始化IOC容器，设置dispatcherServlet地址
 */
public class SpringMvcInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    // 项目对应的配置，初始化容器
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MvcConfig.class};
    }

    // 配置 spring mvc 内部自带的 servlet 访问地址
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
