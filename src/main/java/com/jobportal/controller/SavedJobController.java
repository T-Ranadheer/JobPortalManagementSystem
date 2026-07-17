package com.jobportal.controller;

import com.jobportal.entity.Job;
import com.jobportal.entity.SavedJob;
import com.jobportal.entity.User;
import com.jobportal.service.JobService;
import com.jobportal.service.SavedJobService;
import com.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SavedJobController {

    @Autowired
    private SavedJobService savedJobService;

    @Autowired
    private JobService jobService;

    @Autowired
    private UserService userService;

    @GetMapping("/saved-jobs")
    public String savedJobs(Model model) {

        User user = userService.getUserById(1L);

        model.addAttribute("savedJobs",
                savedJobService.getSavedJobs(user));

        return "saved-jobs";
    }

    @GetMapping("/save-job/{id}")
    public String saveJob(@PathVariable Long id) {

        User user = userService.getUserById(1L);

        Job job = jobService.getJobById(id);

        if (!savedJobService.exists(user, job)) {

            SavedJob savedJob = new SavedJob();

            savedJob.setUser(user);

            savedJob.setJob(job);

            savedJobService.save(savedJob);
        }

        return "redirect:/jobs?success=true";
    }

    @GetMapping("/saved-job/delete/{id}")
    public String deleteSavedJob(@PathVariable Long id) {

        savedJobService.delete(id);

        return "redirect:/saved-jobs";
    }

}