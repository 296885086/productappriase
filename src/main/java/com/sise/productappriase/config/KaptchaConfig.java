package com.sise.productappriase.config;

import com.google.code.kaptcha.servlet.KaptchaServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 验证码
 */
@Component
public class KaptchaConfig {

    @Bean
    public ServletRegistrationBean<KaptchaServlet> kaptchaServlet() {
        //设置验证码的路径
        ServletRegistrationBean<KaptchaServlet> registrationBean = new ServletRegistrationBean<>(new KaptchaServlet(), "/code.jpg");
        registrationBean.addInitParameter("kaptcha.textproducer.char.length", "4");
        registrationBean.addInitParameter("kaptcha.image.width", "130");
        registrationBean.addInitParameter("kaptcha.image.height", "60");
        registrationBean.addInitParameter("kaptcha.textproducer.font.color", "black");
        registrationBean.addInitParameter("kaptcha.background.clear.from", "yellow");
        registrationBean.addInitParameter("kaptcha.background.clear.to", "green");
        registrationBean.addInitParameter("kaptcha.noise.color", "white");
        registrationBean.addInitParameter("kaptcha.session.key", "checkCode");
        registrationBean.addInitParameter("kaptcha.textproducer.font.size", "35");
        registrationBean.addInitParameter("kaptcha.textproducer.char.string", "1234567890");
        registrationBean.addInitParameter("kaptcha.textproducer.font.names", "Monospaced");
        registrationBean.addInitParameter("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.ShadowGimpy");
        return registrationBean;
    }
}
