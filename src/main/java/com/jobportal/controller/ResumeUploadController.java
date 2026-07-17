package com.jobportal.controller;

import com.jobportal.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ResumeUploadController {

    @Autowired
    private ResumeService resumeService;

    @PostMapping("/resume/upload")
    public String uploadResume(
            @RequestParam("resume") MultipartFile file) {

        resumeService.uploadResume(file);

        return "redirect:/profile/view";
    }

}