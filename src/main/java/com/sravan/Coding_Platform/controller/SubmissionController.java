package com.sravan.Coding_Platform.controller;

import com.sravan.Coding_Platform.dto.SubmissionRequest;
import com.sravan.Coding_Platform.model.Submission;
import com.sravan.Coding_Platform.service.SubmissionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @PostMapping
    public Submission createSubmission(@Valid @RequestBody SubmissionRequest request,
                                       Authentication authentication){
        String email = authentication.getName();
        return submissionService.createSubmission(request,email);
    }

    @GetMapping("/my")
    public List<Submission> mySubmissions(Authentication authentication){
        String email = authentication.getName();
        return submissionService.getUserSubmissions(email);
    }
}
