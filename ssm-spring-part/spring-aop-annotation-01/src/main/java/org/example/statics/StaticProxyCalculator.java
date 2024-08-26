package org.example.statics;

import org.example.Calculator;
import org.example.CalculatorPureImpl;

/*
 * 静态代理类
 */
public class StaticProxyCalculator implements Calculator {

    private CalculatorPureImpl calculator;

    public StaticProxyCalculator(CalculatorPureImpl calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.add(i, j);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.sub(i, j);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.mul(i, j);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.div(i, j);
        System.out.println("result = " + result);
        return result;
    }
}
