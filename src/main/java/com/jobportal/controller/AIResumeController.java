package com.jobportal.controller;

import com.jobportal.service.AIResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ai")
public class AIResumeController {

    @Autowired
    private AIResumeService aiResumeService;

    @GetMapping("/resume")
    public String resumePage() {
        return "resume-analyzer";
    }

    @PostMapping("/resume/analyze")
    public String analyzeResume(

            @RequestParam("resume") MultipartFile resume,

            Model model) {

        String result =
                aiResumeService.analyzeResume(resume);

        model.addAttribute("result", result);

        return "resume-analyzer";
    }

}