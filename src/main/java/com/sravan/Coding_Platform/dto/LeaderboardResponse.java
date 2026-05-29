package com.sravan.Coding_Platform.dto;

public class LeaderboardResponse {
    private String email;
    private long solvedCount;

    public LeaderboardResponse(){};
    public LeaderboardResponse(String email,long solvedCount){
        this.email=email;
        this.solvedCount=solvedCount;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public long getSolvedCount(){
        return getSolvedCount();
    }
    public void setSolvedCount(long solvedCount){
        this.solvedCount=solvedCount;
    }
}
