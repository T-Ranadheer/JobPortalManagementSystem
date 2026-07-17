package com.jobportal.controller;

import com.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private JobService jobService;

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("jobs", jobService.getAllJobs());

        return "index";
    }

}