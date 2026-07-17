package com.jobportal.repository;

import com.jobportal.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository
        extends JpaRepository<Interview,Long> {

}