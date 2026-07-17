package com.jobportal.service;

import com.jobportal.entity.Job;

import java.util.List;

public interface AIJobRecommendationService {

    List<Job> recommendJobs(String skills);

}