package com.portfolio.neha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String name, String email, String message) {
        System.out.println("🔥 EMAIL SERVICE CALLED");
        try {
            SimpleMailMessage mail = new SimpleMailMessage();

            mail.setTo("nehajha22004@gmail.com");
            mail.setReplyTo(email); // VERY IMPORTANT
            mail.setSubject("Portfolio Contact Message");

            mail.setText(
                    "Name: " + name + "\n" +
                            "Email: " + email + "\n\n" +
                            "Message:\n" + message
            );

            mailSender.send(mail);

            System.out.println("✅ Email sent successfully");

        } catch (Exception e) {
            System.out.println("❌ Email failed");
            e.printStackTrace();
        }
    }
}