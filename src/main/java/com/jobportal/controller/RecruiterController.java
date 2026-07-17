package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.CategoryService;
import com.jobportal.service.CompanyService;
import com.jobportal.service.JobService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecruiterController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    // ==========================
    // Recruiter Dashboard
    // ==========================

    @GetMapping("/recruiter/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("totalJobs",
                jobService.getAllJobs().size());

        model.addAttribute("totalApplications",
                applicationService.getAllApplications().size());

        model.addAttribute("totalCompanies",
                companyService.getAllCompanies().size());

        model.addAttribute("totalRecruiters",
                userService.getAllUsers()
                        .stream()
                        .filter(u -> u.getRole().name().equals("RECRUITER"))
                        .count());

        model.addAttribute("jobs",
                jobService.getAllJobs());

        return "recruiter-dashboard";
    }

    // ==========================
    // Post Job
    // ==========================

    @GetMapping("/recruiter/post-job")
    public String postJob(Model model) {

        model.addAttribute("job", new Job());

        model.addAttribute("categories",
                categoryService.getAllCategories());

        return "recruiter-post-job";
    }

    @PostMapping("/recruiter/post-job")
    public String saveJob(@ModelAttribute Job job) {

        jobService.saveJob(job);

        return "redirect:/recruiter/dashboard";
    }

    // ==========================
    // Applicants
    // ==========================

    @GetMapping("/recruiter/applicants")
    public String applicants(Model model) {

        model.addAttribute("applications",
                applicationService.getAllApplications());

        return "recruiter-applicants";
    }

    // ==========================
    // Accept Application
    // ==========================

    @GetMapping("/recruiter/application/accept/{id}")
    public String acceptApplication(@PathVariable Long id) {

        applicationService.updateStatus(id, "Accepted");

        return "redirect:/recruiter/applicants";
    }

    // ==========================
    // Reject Application
    // ==========================

    @GetMapping("/recruiter/application/reject/{id}")
    public String rejectApplication(@PathVariable Long id) {

        applicationService.updateStatus(id, "Rejected");

        return "redirect:/recruiter/applicants";

    }

    @GetMapping("/recruiter/manage-jobs")
    public String manageJobs(Model model) {

        model.addAttribute("jobs", jobService.getAllJobs());

        return "recruiter-manage-jobs";
    }

}