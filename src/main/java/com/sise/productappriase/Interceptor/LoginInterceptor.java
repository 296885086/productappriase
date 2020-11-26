package com.sise.productappriase.Interceptor;

import com.sise.productappriase.entity.User;
import com.sise.productappriase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截规则
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User loginUser = (User) request.getSession().getAttribute("loginUser");

        if (loginUser == null){
            String userId = (String) redisTemplate.opsForValue().get("xBiao");
            if (StringUtils.isEmpty(userId)){
                //获取cookie的值
                Cookie[] cookies = request.getCookies();
                if(cookies != null) {
                    for(Cookie cookie : cookies) {
                        if("username".equals(cookie.getName())) {
                            String username = cookie.getValue();
                            User cookieUser = userService.findUserByUsername(username);
                            if (!StringUtils.isEmpty(cookieUser)){
                                request.getSession().setAttribute("loginUser",cookieUser);
                                return true;
                            }
                        }
                    }
                }
                response.sendRedirect(request.getContextPath()+"/common/login");
                return false;
            }else {
                Integer id = Integer.parseInt(userId);
                User user = userService.findUserById(id);
                request.getSession().setAttribute("loginUser",user);
                return true;
            }
        }else {
            return true;
        }
    }
}
