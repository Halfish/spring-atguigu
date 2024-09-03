package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/springmvc")
public class HelloController {

    // 到 handlerMapping中注册
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody   // 直接返回字符串，不去找视图解析器
    public String hello() {
        return "Hello SpringMVC";
    }

    @PostMapping(value="world")
    @ResponseBody
    public String world() {
        return "world SpringMVC";
    }

    @GetMapping(value="name")   // 参数
    @ResponseBody
    public String name(String username) {
        return "hello word, " + username;
    }
}
