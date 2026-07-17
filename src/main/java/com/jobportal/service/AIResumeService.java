package com.jobportal.service;

import org.springframework.web.multipart.MultipartFile;

public interface AIResumeService {

    String analyzeResume(MultipartFile resume);

}