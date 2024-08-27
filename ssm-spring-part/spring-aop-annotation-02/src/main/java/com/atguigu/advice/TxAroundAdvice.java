package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TxAroundAdvice {
    /*
     * 环绕通知，需要在方法中定义目标方法的执行
     */
    @Around("com.atguigu.pintcut.MyPointCut.pc()")
    public Object transaction(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("Around -> 开启事务");
            result = proceedingJoinPoint.proceed(args);
            System.out.println("Around -> 结束事务");
        } catch (Throwable e) {
            System.out.println("Around -> 回滚事务");
            throw new RuntimeException(e);
        }
        return result;
    }
}
