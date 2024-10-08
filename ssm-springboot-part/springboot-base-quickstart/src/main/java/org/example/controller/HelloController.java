package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Value("${bruce.name}")
    private String name;
    
    @GetMapping("boot")
    public String hello() {
        System.out.println("name = " + name);
        return "hello spring!";
    }
}
