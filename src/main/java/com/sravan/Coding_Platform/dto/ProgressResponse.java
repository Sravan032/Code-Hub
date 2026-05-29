package com.sravan.Coding_Platform.dto;

public class ProgressResponse {
    private long totalSolved;
    private long easySolved;
    private long mediumSolved;
    private long hardSolved;

    public ProgressResponse(){};

    public ProgressResponse(
            long totalSolved,
            long easySolved,
            long mediumSolved,
            long hardSolved
    ) {
        this.totalSolved = totalSolved;
        this.easySolved = easySolved;
        this.mediumSolved = mediumSolved;
        this.hardSolved = hardSolved;
    }

    public long getTotalSolved(){
        return totalSolved;
    }
    public void setTotalSolved(long totalSolved) {
        this.totalSolved = totalSolved;
    }

    public long getEasySolved() {
        return easySolved;
    }

    public void setEasySolved(long easySolved) {
        this.easySolved = easySolved;
    }

    public long getMediumSolved() {
        return mediumSolved;
    }

    public void setMediumSolved(long mediumSolved) {
        this.mediumSolved = mediumSolved;
    }

    public long getHardSolved() {
        return hardSolved;
    }

    public void setHardSolved(long hardSolved) {
        this.hardSolved = hardSolved;
    }
}
