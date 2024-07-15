package com.demo.bank.DemoBank.config;

import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfig {
    public static JavaMailSenderImpl getMailConfig(){
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        //Set Properties:
        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");


        //
        emailConfig.setHost("localhost");
        emailConfig.setPort(25);
        emailConfig.setUsername("info@joelin-linbank.com");
        emailConfig.setPassword("Ekassiba@1235$");


        return emailConfig;
    }
    //End Of Email Configuration
}
