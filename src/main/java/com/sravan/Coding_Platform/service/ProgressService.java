package com.sravan.Coding_Platform.service;

import com.sravan.Coding_Platform.dto.ProgressResponse;
import com.sravan.Coding_Platform.model.Submission;
import com.sravan.Coding_Platform.model.User;
import com.sravan.Coding_Platform.repository.SubmissionRepository;
import com.sravan.Coding_Platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProgressService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubmissionRepository submissionRepository;

    public ProgressResponse getUserProgress(String email){
        User user= userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        List<Submission> submissions = submissionRepository.findByUserAndStatus(user,"Accepted");

        int easySolved=0;
        int mediumSolved=0;
        int hardSolved=0;
        Set<Long> solvedProblemIds = new HashSet<>();
        for(Submission submission:submissions){
            Long problemId = submission.getProblem().getId();

            if(solvedProblemIds.contains(problemId)) continue;
            solvedProblemIds.add(problemId);

            String difficulty = submission.getProblem().getDifficulty();
            if(difficulty.equalsIgnoreCase("Easy")) easySolved++;
            else if(difficulty.equalsIgnoreCase("Medium")) mediumSolved++;
            else if(difficulty.equalsIgnoreCase("Hard")) hardSolved++;
        }
        int totalSolved = easySolved+mediumSolved+hardSolved;
        return new ProgressResponse(totalSolved,easySolved,mediumSolved,hardSolved);
    }
}
