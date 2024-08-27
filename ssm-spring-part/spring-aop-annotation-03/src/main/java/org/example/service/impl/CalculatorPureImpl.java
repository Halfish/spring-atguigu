package org.example.service.impl;

import org.example.service.Calculator;
import org.springframework.stereotype.Component;

@Component
public class CalculatorPureImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        return i + j;
    }
}
