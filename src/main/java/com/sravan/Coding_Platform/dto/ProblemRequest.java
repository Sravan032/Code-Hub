package com.sravan.Coding_Platform.dto;

import jakarta.validation.constraints.NotBlank;

public class ProblemRequest {
    @NotBlank(message = "Title is required!")
    private String title;

    @NotBlank(message = "Description is required!")
    private String description;

    @NotBlank(message = "Difficulty is required!")
    private String difficulty;

    public ProblemRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
