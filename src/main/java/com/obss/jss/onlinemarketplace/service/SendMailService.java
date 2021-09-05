package com.obss.jss.onlinemarketplace.service;

import com.obss.jss.onlinemarketplace.model.Mail;

import javax.mail.MessagingException;

public interface SendMailService {

    void sendMail(Mail mail);

    void sendMailWithAttachments(Mail mail) throws MessagingException;
}
