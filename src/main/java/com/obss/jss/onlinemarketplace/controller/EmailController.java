package com.obss.jss.onlinemarketplace.controller;

import com.obss.jss.onlinemarketplace.model.Mail;
import com.obss.jss.onlinemarketplace.service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/mail")
public class EmailController {

    SendMailService service;

    @Autowired
    public EmailController(SendMailService service) {
        this.service = service;
    }


    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@Valid @RequestBody Mail mail) {
        service.sendMail(mail);
        return new ResponseEntity<>("Email Sent successfully", HttpStatus.OK);
    }

    @PostMapping("/attachment")
    public ResponseEntity<String> sendAttachmentEmail(@Valid @RequestBody Mail mail) throws MessagingException {
        service.sendMailWithAttachments(mail);
        return new ResponseEntity<>("Attachment mail sent successfully", HttpStatus.OK);
    }
}
