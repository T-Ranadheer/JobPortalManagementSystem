package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.service.AIJobRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ai")
public class AIJobRecommendationController {

    @Autowired
    private AIJobRecommendationService recommendationService;

    @GetMapping("/recommendation")
    public String recommendationPage() {

        return "ai-job-recommendation";

    }

    @PostMapping("/recommendation")
    public String recommendJobs(

            @RequestParam("skills") String skills,

            Model model) {

        List<Job> jobs =
                recommendationService.recommendJobs(skills);

        model.addAttribute("jobs", jobs);

        model.addAttribute("skills", skills);

        return "ai-job-recommendation";
    }

}