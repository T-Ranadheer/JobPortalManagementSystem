package com.jobportal.controller;

import com.jobportal.entity.User;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppliedJobController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private UserService userService;

    @GetMapping("/applied-jobs")
    public String appliedJobs(Authentication authentication, Model model) {

        // Logged-in user's email
        String email = authentication.getName();

        // Fetch logged-in user
        User user = userService.getUserByEmail(email);

        // User's applications
        model.addAttribute(
                "applications",
                applicationService.getApplicationsByUser(user));

        return "applied-jobs";
    }

}