package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs/search")
    public String searchJobs(

            @RequestParam(required = false) String title,

            @RequestParam(required = false) String location,

            @RequestParam(required = false) String company,

            Model model) {

        List<Job> jobs;

        if (title != null && !title.isEmpty()) {

            jobs = jobService.searchByTitle(title);

        } else if (location != null && !location.isEmpty()) {

            jobs = jobService.searchByLocation(location);

        } else if (company != null && !company.isEmpty()) {

            jobs = jobService.searchByCompany(company);

        } else {

            jobs = jobService.getAllJobs();

        }

        model.addAttribute("jobs", jobs);

        return "jobs";
    }

}