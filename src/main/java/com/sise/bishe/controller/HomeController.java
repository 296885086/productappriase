package com.sise.bishe.controller;

import com.sise.bishe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    HttpSession session;

    @RequestMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("/home");
    }

    @RequestMapping("/header")
    public ModelAndView header(){
        User loginUser = (User) session.getAttribute("loginUser");
        ModelAndView mv = new ModelAndView();
        mv.addObject("username",loginUser.getRealName());
        mv.setViewName("/header");
        return mv;
    }

/*    @RequestMapping("/init")
    public Result init(){
        List<Goods> hotGoods = goodsService.findHotGoods(1);
        List<Goods> newGoods = goodsService.findNewGoods();
        Map<String, Object> map = new HashMap<>();
        map.put("hotGoods",hotGoods);
        map.put("newGoods",newGoods);
        return new Result(true,"初始化界面",map);
    }*/
}
