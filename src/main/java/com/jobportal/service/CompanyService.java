package com.jobportal.service;

import com.jobportal.entity.Company;
import com.jobportal.entity.User;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    Company getCompanyById(Long id);

    Company getCompanyByRecruiter(User recruiter);

    List<Company> getAllCompanies();

    Company getCompany(Long id);

    void deleteCompany(Long id);

}