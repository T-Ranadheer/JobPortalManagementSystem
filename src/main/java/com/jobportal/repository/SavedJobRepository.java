package com.jobportal.repository;

import com.jobportal.entity.SavedJob;
import com.jobportal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedJobRepository extends JpaRepository<SavedJob, Long> {

    List<SavedJob> findByUser(User user);

    boolean existsByUserAndJob(User user, com.jobportal.entity.Job job);

}