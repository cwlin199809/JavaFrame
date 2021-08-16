package com.cwlin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringBoot08TaskApplicationTests {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        //邮件设置1：一个简单的邮件
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("通知--秋季开学");
        mailMessage.setText("于2021.08.01开学，请按时到校报到！");

        mailMessage.setTo("1208793450@qq.com");
        mailMessage.setFrom("1208793450@qq.com");

        mailSender.send(mailMessage);
    }

    @Test
    void contextLoads2() throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true,"utf-8"); //支持多文件

        mimeMessageHelper.setSubject("通知--秋季开学");
        mimeMessageHelper.setText("<b style='color:red'>于2021.08.01开学，请按时到校报到！</b>",true); //支持html

        mimeMessageHelper.addAttachment("1.jpg", new File("C:/Users/醉染/Desktop/1.jpg"));
        mimeMessageHelper.addAttachment("2.jpg", new File("C:/Users/醉染/Desktop/2.jpg"));

        mimeMessageHelper.setTo("1208793450@qq.com");
        mimeMessageHelper.setFrom("1208793450@qq.com");

        mailSender.send(mimeMessage);
    }

    @Test
    /**
     * @author cwlin
     * @creed Talk is cheap,show me the code
     * @description TODO
     * @date 2021/8/16 13:22
     * @param multipart: 是否支持多文件
     * @param encoding: 邮件编码
     * @param subject: 标题
     * @param text: 正文
     * @param html: 是否支持html
     * @return void
     */
    void sendMailMessage(boolean multipart, String encoding, String subject, String text, boolean html) throws MessagingException {
        //邮件设置2：一个复杂的邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, multipart, encoding);

        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, html);

        mimeMessageHelper.addAttachment("1.jpg", new File("C:/Users/醉染/Desktop/1.jpg"));
        mimeMessageHelper.addAttachment("2.jpg", new File("C:/Users/醉染/Desktop/2.jpg"));

        mimeMessageHelper.setTo("1208793450@qq.com");
        mimeMessageHelper.setFrom("1208793450@qq.com");

        mailSender.send(mimeMessage);
    }
}
