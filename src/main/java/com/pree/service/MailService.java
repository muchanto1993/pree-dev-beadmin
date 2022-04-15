package com.pree.service;

import com.pree.format.mail.DataMailFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(DataMailFormat dataMailFormat) {
        log.info("To : " + dataMailFormat.getTo());
        log.info("Subject : " + dataMailFormat.getSubject());
        log.info("Text : " + dataMailFormat.getText());

        log.info("Sending Email...");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(dataMailFormat.getTo());

        mailMessage.setSubject(dataMailFormat.getSubject());
        mailMessage.setText(dataMailFormat.getText());

        javaMailSender.send(mailMessage);
        log.info("Done Sending Email...");
    }

}
