package com.obss.jss.onlinemarketplace.service.impl;

import com.obss.jss.onlinemarketplace.model.Mail;
import com.obss.jss.onlinemarketplace.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service
public class SendMailServiceImpl implements SendMailService {
    private final JavaMailSender javaMailSender;

    @Autowired
    public SendMailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
    @Override
    public void sendMail(Mail mail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail.getRecipient(), mail.getRecipient());

        msg.setSubject(mail.getSubject());
        msg.setText(mail.getMessage());

        javaMailSender.send(msg);
    }

    @Override
    public void sendMailWithAttachments(Mail mail) throws MessagingException {
        MimeMessage msg = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo("to_@email");

        helper.setSubject("Testing from Spring Boot");

        helper.setText("Find the attached image", true);

        helper.addAttachment("hero.jpg", new ClassPathResource("hero.jpg"));

        javaMailSender.send(msg);

    }
}
