package com.jobportal.service;

import com.jobportal.entity.Application;
import com.jobportal.entity.User;
import com.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationRepository repository;

    @Override
    public Application save(Application application) {
        return repository.save(application);
    }

    @Override
    public List<Application> getAllApplications() {
        return repository.findAll();
    }

    @Override
    public List<Application> getApplicationsByJob(Long jobId) {
        return repository.findByJobId(jobId);
    }

    @Override
    public List<Application> getApplicationsByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Application getApplicationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Application application) {
        repository.save(application);
    }

    // NEW METHOD
    @Override
    public void updateStatus(Long id, String status) {

        Application application = repository.findById(id).orElse(null);

        if (application != null) {

            application.setStatus(status);

            repository.save(application);

        }

    }

}