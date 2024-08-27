package org.example.advice;

import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Order;
import org.springframework.stereotype.Component;

@Component
public class TxAdvice {

    public void begin() {
        System.out.println("TxAdvice -> begin");
    }

    public void commit() {
        System.out.println("TxAdvice -> commit");
    }

    public void rollback() {
        System.out.println("TxAdvice -> rollback");
    }
}
