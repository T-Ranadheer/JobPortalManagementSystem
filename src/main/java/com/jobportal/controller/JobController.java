package com.jobportal.controller;

import com.jobportal.service.CategoryService;
import com.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/jobs")
    public String jobs(Model model) {

        System.out.println("==================================");
        System.out.println("Total Jobs : " + jobService.getAllJobs().size());
        System.out.println(jobService.getAllJobs());
        System.out.println("==================================");

        model.addAttribute("jobs", jobService.getAllJobs());

        model.addAttribute("categories",
                categoryService.getAllCategories());

        return "jobs";
    }

    @GetMapping("/job/{id}")
    public String viewJob(@PathVariable Long id,
                          Model model) {

        model.addAttribute("job",
                jobService.getJobById(id));

        return "job-details";
    }
}