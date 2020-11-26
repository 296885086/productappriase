package com.sise.bishe.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {

    /*
* 注册页面*/
    @GetMapping("/hellospring")
    public ModelAndView register(Model model) {
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

}