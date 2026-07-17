package com.jobportal.service;

import com.jobportal.entity.Interview;

import java.util.List;

public interface InterviewService {

    Interview saveInterview(Interview interview);

    List<Interview> getAllInterviews();

    Interview getInterviewById(Long id);

    void deleteInterview(Long id);

}