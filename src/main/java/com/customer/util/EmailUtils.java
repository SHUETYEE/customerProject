package com.customer.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * @author 李靖宇
 * @Project customerProject
 * @date 2019/12/4 13:06
 * @commit 生活明朗，万物可爱，人间值得，未来可期
 */
public class EmailUtils {

    /**
     *
     * 发送简单邮件
     *
     * @param userEmail  用户的email,,多个用`,` 隔开
     * @param subject  主题
     * @param text  内容
     * @return  发送成功返回true
     */
    public static Boolean sendEmail(String userEmail,String subject, String text){
        try {
            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            String fromEmail = "litblue@163.com";
            javaMailSender.setHost("smtp.163.com");
            javaMailSender.setUsername("litblue@163.com");
            javaMailSender.setPassword("litblue962464");
            //加认证机制
            Properties javaMailProperties = new Properties();
            javaMailProperties.put("mail.smtp.auth", true);
            javaMailProperties.put("mail.smtp.starttls.enable", true);
            javaMailProperties.put("mail.smtp.timeout", 5000);
            javaMailSender.setJavaMailProperties(javaMailProperties);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(userEmail);
            message.setSubject(subject);
            message.setText(text);
            javaMailSender.send(message);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public static void main(String[] args) {
        EmailUtils.sendEmail("1184683152@qq.com","想念你","哈哈");
    }

}
