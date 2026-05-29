package com.sravan.Coding_Platform.controller;

import com.sravan.Coding_Platform.dto.ProgressResponse;
import com.sravan.Coding_Platform.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/progress")
public class ProgressController {
    @Autowired
    private ProgressService progressService;

    @GetMapping
    public ProgressResponse getProgress(Authentication authentication){
        String email = authentication.getName();
        return progressService.getUserProgress(email);
    }
}
