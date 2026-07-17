package com.jobportal.service;

import com.jobportal.dto.DashboardDTO;
import com.jobportal.entity.Role;
import com.jobportal.repository.ApplicationRepository;
import com.jobportal.repository.CompanyRepository;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public DashboardDTO getDashboardData() {

        DashboardDTO dto = new DashboardDTO();

        dto.setTotalJobs(jobRepository.count());

        dto.setTotalApplicants(applicationRepository.count());

        dto.setTotalCompanies(companyRepository.count());

        dto.setTotalRecruiters(
                userRepository.countByRole(Role.RECRUITER)
        );

        return dto;
    }

}