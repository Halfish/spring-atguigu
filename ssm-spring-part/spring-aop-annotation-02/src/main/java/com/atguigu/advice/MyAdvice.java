package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Component
@Aspect
public class MyAdvice {

    @Before("execution(* com..impl.*.*(..))")
    public void before(JoinPoint joinPoint) {
        // 1. 获取类名
        String name = joinPoint.getTarget().getClass().getName();
        System.out.println("Before -> Class name = " + name);

        // 2. 获取方法名
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before -> modifier = " + s + ", methodName = " + methodName);

        // 3. 获取参数列表
        Object[] args = joinPoint.getArgs();
        System.out.println("Before -> args = " + args);
    }

    @AfterReturning(value = "execution(* com..impl.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Integer result) {
        System.out.println("AfterReturning -> joinPoint = " + joinPoint);
        System.out.println("AfterReturning -> result = " + result);
    }

    @After("execution(* com..impl.*.*(..))")
    public void after() {
        System.out.println("After -> .. ");
    }

    @AfterThrowing(value = "execution(* com..impl.*.*(..))", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("AfterThrowing -> joinPoint = " + joinPoint);
        System.out.println("AfterThrowing -> throwable = " + throwable);
    }
}
