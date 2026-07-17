package com.jobportal.service;

import com.jobportal.entity.Job;
import com.jobportal.entity.SavedJob;
import com.jobportal.entity.User;

import java.util.List;

public interface SavedJobService {

    SavedJob save(SavedJob savedJob);

    List<SavedJob> getSavedJobs(User user);

    void delete(Long id);

    boolean exists(User user, Job job);

}