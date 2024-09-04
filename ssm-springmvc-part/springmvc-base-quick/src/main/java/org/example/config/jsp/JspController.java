package org.example.config.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jsp")
public class JspController {

    /*
     * 快速查找视图。
     *  1. 方法返回的是字符串就行；
     *  2. 不要添加 @ResponseBody
     *  3. 返回值对应中间的视图名称
     */
    @GetMapping("index")
    public String index() {
        return "index";
    }

    /*
     * 转发
     */
    @GetMapping("forward")
    public String forward() {
        return "forward:/jsp/index";
    }

    /*
     * 重定向
     */
    @GetMapping("redirect")
    public String redirect() {
        return "redirect:/jsp/index";
    }
}
