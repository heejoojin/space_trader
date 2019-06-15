package com.example.m4.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

public class ConfigurationViewModel extends AndroidViewModel {

    private int score = 16;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
}
