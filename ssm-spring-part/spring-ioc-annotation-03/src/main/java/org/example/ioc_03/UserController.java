package org.example.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    public void show() {
        String result = userService.show();
        System.out.println(result);
    }
}
