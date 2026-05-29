package com.sravan.Coding_Platform.controller;

import com.sravan.Coding_Platform.dto.LeaderboardResponse;
import com.sravan.Coding_Platform.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/leaderboard")
public class LeaderboardController {
    @Autowired
    private LeaderboardService leaderboardService;
    @GetMapping
    public List<LeaderboardResponse> getLeaderboard(){
        return leaderboardService.getLeaderboard();
    }
}
