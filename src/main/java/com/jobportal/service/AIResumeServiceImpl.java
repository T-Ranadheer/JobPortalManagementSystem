package com.jobportal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AIResumeServiceImpl implements AIResumeService {

    @Override
    public String analyzeResume(MultipartFile resume) {

        String fileName = resume.getOriginalFilename();

        if (fileName == null) {
            return "Resume not uploaded.";
        }

        fileName = fileName.toLowerCase();

        if (fileName.contains("java")) {
            return "AI Result: Excellent match for Java Developer.";
        }

        if (fileName.contains("python")) {
            return "AI Result: Suitable for Python Developer.";
        }

        if (fileName.contains("react")) {
            return "AI Result: Suitable for Frontend Developer.";
        }

        return "AI Result: Resume uploaded successfully. Manual review recommended.";
    }

}