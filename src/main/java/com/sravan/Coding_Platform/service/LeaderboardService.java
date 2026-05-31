package com.sravan.Coding_Platform.service;

import com.sravan.Coding_Platform.dto.LeaderboardResponse;
import com.sravan.Coding_Platform.model.Submission;
import com.sravan.Coding_Platform.model.User;
import com.sravan.Coding_Platform.repository.SubmissionRepository;
import com.sravan.Coding_Platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LeaderboardService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubmissionRepository submissionRepository;

    @Cacheable("leaderboard")
    public List<LeaderboardResponse> getLeaderboard(){
        List<User> users = userRepository.findAll();

        List<LeaderboardResponse> leaderboard = new ArrayList<>();

        for(User user:users){
            List<Submission> submissions = submissionRepository.findByUserAndStatus(user,"Accepted");
            Set<Long> solvedProblemIds = new HashSet<>();

            for(Submission submission:submissions){
                long problemId = submission.getProblem().getId();
                solvedProblemIds.add(problemId);
            }
            leaderboard.add(new LeaderboardResponse(user.getEmail(), solvedProblemIds.size()));
        }

        leaderboard.sort((a,b)->Long.compare(b.getSolvedCount(),a.getSolvedCount()));
        System.out.println("Leaderboard got from DB");
        return leaderboard;
    }
}
