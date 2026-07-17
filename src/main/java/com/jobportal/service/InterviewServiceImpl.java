package com.jobportal.service;

import com.jobportal.entity.Interview;
import com.jobportal.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    @Override
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @Override
    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }

}