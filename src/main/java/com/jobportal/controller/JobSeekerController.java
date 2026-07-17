package com.jobportal.controller;

import com.jobportal.entity.Application;
import com.jobportal.entity.SavedJob;
import com.jobportal.entity.User;
import com.jobportal.service.ApplicationService;
import com.jobportal.service.SavedJobService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class JobSeekerController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationService applicationService;

    @Autowired
    private SavedJobService savedJobService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        // Temporary user
        User user = userService.getUserById(1L);

        List<Application> applications =
                applicationService.getApplicationsByUser(user);

        List<SavedJob> savedJobs =
                savedJobService.getSavedJobs(user);

        long pending =
                applications.stream()
                        .filter(a -> a.getStatus().equals("Pending"))
                        .count();

        long accepted =
                applications.stream()
                        .filter(a -> a.getStatus().equals("Accepted"))
                        .count();

        model.addAttribute("user", user);
        model.addAttribute("applications", applications);
        model.addAttribute("savedJobs", savedJobs);

        model.addAttribute("appliedCount",
                applications.size());

        model.addAttribute("savedCount",
                savedJobs.size());

        model.addAttribute("pendingCount",
                pending);

        model.addAttribute("acceptedCount",
                accepted);

        return "jobseeker-dashboard";
    }

}