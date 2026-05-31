package com.sravan.Coding_Platform.service;

import com.sravan.Coding_Platform.dto.SubmissionRequest;
import com.sravan.Coding_Platform.model.Problem;
import com.sravan.Coding_Platform.model.Submission;
import com.sravan.Coding_Platform.model.User;
import com.sravan.Coding_Platform.repository.ProblemRepository;
import com.sravan.Coding_Platform.repository.SubmissionRepository;
import com.sravan.Coding_Platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private UserRepository userRepository;

    @CacheEvict(value = "leaderboard", allEntries = true)
    public Submission createSubmission(SubmissionRequest request, String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("User not found!"));

        Problem problem = problemRepository.findById(request.getProblemId())
                .orElseThrow(() -> new RuntimeException("Problem not found!"));

        Submission submission = new Submission();
        submission.setCode(request.getCode());
        submission.setLanguage(request.getLanguage());
        submission.setStatus("Accepted");
        submission.setSubmittedAt(LocalDateTime.now());
        submission.setUser(user);
        submission.setProblem(problem);

        return submissionRepository.save(submission);
    }

    public List<Submission> getUserSubmissions(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("User not found!"));

        return submissionRepository.findByUser(user);
    }
}
