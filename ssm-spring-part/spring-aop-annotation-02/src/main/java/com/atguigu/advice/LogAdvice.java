package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 增强类的内部要存储增强代码
 */
@Component
@Aspect
@Order(value=10)  // 指定优先级，值越小优先级越高
public class LogAdvice {

    // 定义一个切点表达式
    @Pointcut("execution(* com.atguigu.service.impl.*.*(..))")
    public void pc() {}

    @Before("pc()")     // 直接引用切点表达式
    public void start() {
        System.out.println("方法开始");
    }

//    @AfterReturning("execution(* com.atguigu.service.impl.*.*(..))")
    // 引用别的类中的切点表达式
    @AfterReturning("com.atguigu.pintcut.MyPointCut.pc()")
    public void afterReturning() {
        System.out.println("方法返回");
    }

    @After("execution(* com.atguigu.service.impl.*.*(..))")
    public void after() {
        System.out.println("方法结束");
    }

    @AfterThrowing("execution(* com.atguigu.service.impl.*.*(..))")
    public void error() {
        System.out.println("方法报错");
    }
}
