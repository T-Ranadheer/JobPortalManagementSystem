package com.jobportal.service;

import com.jobportal.entity.Job;

import java.util.List;

public interface JobService {

    Job saveJob(Job job);

    List<Job> getAllJobs();

    Job getJobById(Long id);

    void deleteJob(Long id);

    List<Job> searchByTitle(String keyword);

    List<Job> searchByLocation(String location);

    List<Job> searchByCompany(String company);

}