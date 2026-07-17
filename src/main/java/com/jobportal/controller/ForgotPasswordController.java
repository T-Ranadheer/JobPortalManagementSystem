package com.jobportal.controller;

import com.jobportal.entity.User;
import com.jobportal.service.EmailService;
import com.jobportal.service.OtpService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private OtpService otpService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {

        return "forgot-password";
    }

    @PostMapping("/send-otp")
    public String sendOtp(@RequestParam String email,
                          Model model) {

        User user = userService.getUserByEmail(email);

        if (user == null) {

            model.addAttribute("error",
                    "Email not found");

            return "forgot-password";
        }

        String otp = otpService.generateOtp(email);

        emailService.sendOtp(email, otp);

        model.addAttribute("email", email);

        return "verify-otp";
    }

    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email,
                            @RequestParam String otp,
                            Model model) {

        if (!otpService.verifyOtp(email, otp)) {

            model.addAttribute("email", email);

            model.addAttribute("error",
                    "Invalid OTP");

            return "verify-otp";
        }

        model.addAttribute("email", email);

        return "reset-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email,
                                @RequestParam String password) {

        User user = userService.getUserByEmail(email);

        user.setPassword(passwordEncoder.encode(password));

        userService.updateUser(user);

        otpService.removeOtp(email);

        return "redirect:/login?resetSuccess";
    }

}