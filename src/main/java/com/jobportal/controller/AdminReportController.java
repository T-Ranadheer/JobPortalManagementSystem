package com.jobportal.controller;

import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.CompanyRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminReportController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping("/admin/reports")
    public String reports(Model model){

        model.addAttribute("users", userRepository.count());

        model.addAttribute("jobs", jobRepository.count());

        model.addAttribute("companies", companyRepository.count());

        model.addAttribute("applications", applicationRepository.count());

        return "admin-reports";
    }

}