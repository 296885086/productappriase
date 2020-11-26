package com.sise.bishe.controller;

import com.sise.bishe.config.MailService;
import com.sise.bishe.entity.Result;
import com.sise.bishe.entity.User;
import com.sise.bishe.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 登陆，注册，找回密码
 */
@RestController
@RequestMapping("/common/")
public class CommonController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MailService mailService;

    @Autowired
    HttpSession session;

    @Autowired
    HttpServletResponse response;

    @RequestMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/login");
    }

    @RequestMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("/register");
    }

    @RequestMapping("/toChangePwd")
    public ModelAndView toChangePwd(){
        return new ModelAndView("/changePwd");
    }

    @RequestMapping("/toLogin")
    public Result login(@RequestBody Map<String,Object> map){
        String msg = null;
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        int remember = (int) map.get("remember");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            msg = "用户名或密码不能为空";
        }else {
            String loginCode = (String) map.get("code");
            if (!StringUtils.isEmpty(loginCode)){
                String code = (String) session.getAttribute("checkCode");
                if (loginCode.equals(code)){
                    User loginUser = userService.findUserByUsernameAndPwd(username,password);
                    if (!StringUtils.isEmpty(loginUser)){
                        msg = "登录成功";
                        loginUser.setPassword(null);
                        if (remember == 1){
                            //用户信息存储在cookIe，用于免密登陆或拦截
                            Cookie cookie = new Cookie("username",loginUser.getUsername());
                            cookie.setMaxAge(60*60*24);
                            cookie.setPath("/");
                            response.addCookie(cookie);
                        }
                        session.setAttribute("loginUser",loginUser);
                        return new Result(true,"登录验证",msg);
                    }else {
                        msg = "登录失败";
                    }
                }else {
                    msg = "验证码错误";
                }
            }else {
                msg = "验证码不能为空";
            }
        }
        return new Result(false,"登录验证",msg);
    }

    @GetMapping("/sendCode")
    @ResponseBody
    public Result sendCode(@RequestParam("email") String email,
                           @RequestParam("username")String username){
        User user = userService.findUserByEmailAndUsername(email, username);
        if (!StringUtils.isEmpty(user)){
            String redisCode = (String) redisTemplate.opsForValue().get("xBiao_" + username);
            if (StringUtils.isEmpty(redisCode)){
                redisCode = RandomStringUtils.randomNumeric(6);
                StringRedisSerializer serializer = new StringRedisSerializer();
                redisTemplate.setKeySerializer(serializer);
                redisTemplate.setValueSerializer(serializer);
                redisTemplate.opsForValue().set("xBiao_"+user.getUsername(),redisCode,300, TimeUnit.SECONDS);
            }
            //session.setAttribute("emailCode",emailCode);
            mailService.sandSimpleMail("2692841607@qq.com",email
                    ,"商场平台密码找回","验证码为：" + redisCode + "，5分钟内有效。");
            return new Result(true,"发送成功","发送成功");
        }else {
            return new Result(false,"发送失败","发送失败");
        }
    }

    @RequestMapping("/doSave")
    public Result doSave(@RequestBody User user){
        int i = userService.save(user);
        if (i == 1){
            return new Result(true,"注册成功",i);
        }
        return new Result(false,"用户名重复",i);
    }

    @RequestMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String,Object> map){
        String msg = "更新失败";
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        String code = (String) map.get("code");
        String emailCode = (String) redisTemplate.opsForValue().get("xBiao_" + username);
        //String emailCode = (String) session.getAttribute("emailCode");
        if (code.equals(emailCode)){
            User user = userService.findUserByUsername(username);
            user.setPassword(password);
            userService.updateUser(user);
            //更新成功，删除验证缓存
            redisTemplate.delete("xBiao_" + username);
            msg = "更新成功";
            return new Result(true,"更新成功",msg);
        }else {
            msg = "验证码错误";
        }
        return new Result(false,"验证码错误",msg);
    }

    @RequestMapping("/logout")
    public ModelAndView logout(){
        session.removeAttribute("loginUser");
        Cookie cookie = new Cookie("username",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return new ModelAndView("/login");
    }
}