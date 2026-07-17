package com.jobportal.service;

import com.jobportal.entity.Application;
import com.jobportal.entity.User;

import java.util.List;

public interface ApplicationService {

    Application save(Application application);

    List<Application> getAllApplications();

    List<Application> getApplicationsByJob(Long jobId);

    List<Application> getApplicationsByUser(User user);

    Application getApplicationById(Long id);

    void update(Application application);

    // NEW
    void updateStatus(Long id, String status);

}