package com.jobportal.controller;

import com.jobportal.entity.Application;
import com.jobportal.entity.Interview;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recruiter")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private ApplicationService applicationService;

    @GetMapping("/schedule-interview/{id}")
    public String scheduleInterview(
            @PathVariable Long id,
            Model model) {

        Application application =
                applicationService.getApplicationById(id);

        Interview interview = new Interview();

        interview.setApplication(application);

        model.addAttribute("interview", interview);

        return "schedule-interview";
    }

    @PostMapping("/save-interview")
    public String saveInterview(
            @ModelAttribute Interview interview) {

        interviewService.saveInterview(interview);

        return "redirect:/recruiter/interviews";
    }

    @GetMapping("/interviews")
    public String interviews(Model model) {

        model.addAttribute("interviews",
                interviewService.getAllInterviews());

        return "interview-list";
    }

    @GetMapping("/delete-interview/{id}")
    public String deleteInterview(
            @PathVariable Long id) {

        interviewService.deleteInterview(id);

        return "redirect:/recruiter/interviews";
    }

}