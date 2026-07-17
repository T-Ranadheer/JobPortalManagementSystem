package com.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    public void sendOtp(String email, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(fromEmail);

        message.setTo(email);

        message.setSubject("Job Portal Password Reset OTP");

        message.setText(
                "Hello,\n\n" +
                        "Your OTP for resetting your Job Portal password is:\n\n" +
                        otp +
                        "\n\nThis OTP is valid for 5 minutes.\n" +
                        "Do not share it with anyone.\n\n" +
                        "Regards,\n" +
                        "Job Portal Team"
        );

        mailSender.send(message);
    }
}