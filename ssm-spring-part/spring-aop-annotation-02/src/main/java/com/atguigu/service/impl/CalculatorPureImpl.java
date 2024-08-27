package com.atguigu.service.impl;

import com.atguigu.service.Calculator;
import org.springframework.stereotype.Component;

/*
 * 注意: AOP只支持IoC容器里的组件
 */
@Component
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        return i / j;
    }
}
