package com.atguigu.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
 * 添加事务，普通的方式
 */
@Component
@Aspect
@Order(value=1)  // 指定优先级，值越小优先级越高
public class TxAdvice {

    @Before("com.atguigu.pintcut.MyPointCut.pc()")
    public void begin() {
        System.out.println("TxAdvice -> 开始事务");
    }

    @AfterReturning("com.atguigu.pintcut.MyPointCut.pc()")
    public void commit() {
        System.out.println("TxAdvice -> 提交事务");
    }

    @AfterThrowing("com.atguigu.pintcut.MyPointCut.pc()")
    public void rollback() {
        System.out.println("TxAdvice -> 回滚事务");
    }
}
