package com.sise.bishe.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * 邮箱发送
 */
@Component
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    //发送简单邮件
    public void sandSimpleMail(String from,String to,String subject,String content)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        javaMailSender.send(mailMessage);

    }
}
