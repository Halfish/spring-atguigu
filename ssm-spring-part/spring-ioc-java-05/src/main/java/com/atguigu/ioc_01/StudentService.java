package com.atguigu.ioc_01;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void ping() {
        System.out.println("Hello from Student Service");
    }
}
