package com.jobportal.controller;

import com.jobportal.service.ApplicationService;
import com.jobportal.service.CompanyService;
import com.jobportal.service.JobService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ApplicationService applicationService;

    // Admin Dashboard
    @GetMapping("/admin/dashboard")
    public String dashboard(Model model){

        model.addAttribute("totalUsers",
                userService.getAllUsers().size());

        model.addAttribute("totalJobs",
                jobService.getAllJobs().size());

        model.addAttribute("totalCompanies",
                companyService.getAllCompanies().size());

        model.addAttribute("totalApplications",
                applicationService.getAllApplications().size());

        model.addAttribute("users",
                userService.getAllUsers());

        return "admin-dashboard";
    }

    // Manage Users
    @GetMapping("/admin/users")
    public String manageUsers(Model model){

        model.addAttribute("users",
                userService.getAllUsers());

        return "admin-users";
    }

    // Delete User
    @GetMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

        return "redirect:/admin/users";
    }

    // ==========================
// Manage Recruiters
// ==========================

    @GetMapping("/admin/recruiters")
    public String manageRecruiters(Model model){

        model.addAttribute("recruiters",

                userService.getAllUsers()
                        .stream()
                        .filter(user -> user.getRole().name().equals("RECRUITER"))
                        .toList());

        return "admin-recruiters";
    }

    @GetMapping("/admin/recruiter/delete/{id}")
    public String deleteRecruiter(@PathVariable Long id){

        userService.deleteUser(id);

        return "redirect:/admin/recruiters";
    }
    // ==========================
// Manage Jobs
// ==========================

    @GetMapping("/admin/jobs")
    public String manageJobs(Model model){

        model.addAttribute("jobs",
                jobService.getAllJobs());

        return "admin-jobs";
    }

    @GetMapping("/admin/job/delete/{id}")
    public String deleteJob(@PathVariable Long id){

        jobService.deleteJob(id);

        return "redirect:/admin/jobs";
    }

    // ==========================
// Manage Companies
// ==========================

    @GetMapping("/admin/companies")
    public String manageCompanies(Model model){

        model.addAttribute("companies",
                companyService.getAllCompanies());

        return "admin-companies";
    }

    @GetMapping("/admin/company/delete/{id}")
    public String deleteCompany(@PathVariable Long id){

        companyService.deleteCompany(id);

        return "redirect:/admin/companies";
    }

}