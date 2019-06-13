package com.example.m4.model;

public enum Difficulty {

    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");

    private String difficulty;

    // Constructor
    Difficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    // Getter
    public String getDifficulty() {
        return difficulty;
    }

    // Setter
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return difficulty;
    }
}
