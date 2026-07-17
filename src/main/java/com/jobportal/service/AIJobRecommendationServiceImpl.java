package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIJobRecommendationServiceImpl
        implements AIJobRecommendationService {

    @Autowired
    private JobRepository jobRepository;

    @Override
    public List<Job> recommendJobs(String skills) {

        List<Job> allJobs = jobRepository.findAll();

        List<Job> recommendedJobs = new ArrayList<>();

        if (skills == null || skills.isEmpty()) {
            return allJobs;
        }

        skills = skills.toLowerCase();

        for (Job job : allJobs) {

            String title = job.getTitle() == null ? "" : job.getTitle().toLowerCase();

            String description = job.getDescription() == null
                    ? ""
                    : job.getDescription().toLowerCase();

            if (title.contains(skills)
                    || description.contains(skills)) {

                recommendedJobs.add(job);

            }

        }

        return recommendedJobs;
    }

}