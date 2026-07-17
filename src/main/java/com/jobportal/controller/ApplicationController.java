package com.jobportal.controller;

import com.jobportal.entity.Application;
import com.jobportal.entity.Job;
import com.jobportal.entity.User;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.JobService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    // Open Apply Page
    @GetMapping("/apply/{id}")
    public String applyPage(@PathVariable Long id, Model model) {

        Job job = jobService.getJobById(id);

        model.addAttribute("job", job);

        return "apply-job";
    }

    // Submit Application
    @PostMapping("/apply-job")
    public String applyJob(

            @RequestParam("jobId") Long jobId,

            @RequestParam("name") String name,

            @RequestParam("email") String email,

            @RequestParam("phone") String phone,

            @RequestParam("resume") MultipartFile resume

    ) throws IOException {

        Job job = jobService.getJobById(jobId);

        User user = userService.getUserById(1L);

        // Upload Folder
        String uploadPath = System.getProperty("user.dir")
                + File.separator
                + "uploads"
                + File.separator
                + "resumes";

        File folder = new File(uploadPath);

        if (!folder.exists()) {
            folder.mkdirs();
        }

        // Resume File Name
        String fileName = System.currentTimeMillis()
                + "_"
                + resume.getOriginalFilename();

        File destination = new File(folder, fileName);

        resume.transferTo(destination);

        // Save Application
        Application application = new Application();

        application.setJob(job);

        application.setUser(user);

        application.setApplicantName(name);

        application.setApplicantEmail(email);

        application.setPhone(phone);

        application.setResume(fileName);

        application.setStatus("Pending");

        applicationService.save(application);

        return "redirect:/jobs?success";
    }

}