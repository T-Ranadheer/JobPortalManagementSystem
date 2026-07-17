package com.jobportal.controller;

import com.jobportal.entity.Company;
import com.jobportal.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recruiter/company")
public class RecruiterCompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/profile")
    public String profile(Model model) {

        model.addAttribute("company", new Company());

        return "company-profile";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Company company) {

        companyService.saveCompany(company);

        return "redirect:/recruiter/company/profile?success";
    }
}