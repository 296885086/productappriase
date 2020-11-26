package com.sise.bishe.config;

import com.sise.bishe.Interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 图片绝对地址与虚拟地址映射
 */

//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    //文件磁盘图片url 映射
    //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径file:/C:/Users/damo/Desktop/image/
        registry.addResourceHandler("/image/**").addResourceLocations("file:/C:/Users/damo/Desktop/image/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/common/**","/wx/**","/css/**","/fonts/**","/images/**","/js/**");
    }
}
