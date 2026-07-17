package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.entity.SavedJob;
import com.jobportal.entity.User;
import com.jobportal.repository.SavedJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavedJobServiceImpl implements SavedJobService {

    @Autowired
    private SavedJobRepository savedJobRepository;

    @Override
    public SavedJob save(SavedJob savedJob) {
        return savedJobRepository.save(savedJob);
    }

    @Override
    public List<SavedJob> getSavedJobs(User user) {
        return savedJobRepository.findByUser(user);
    }

    @Override
    public void delete(Long id) {
        savedJobRepository.deleteById(id);
    }

    @Override
    public boolean exists(User user, Job job) {
        return savedJobRepository.existsByUserAndJob(user, job);
    }

}