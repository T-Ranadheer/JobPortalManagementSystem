package com.jobportal.service;

import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {

    void uploadResume(MultipartFile file);

}