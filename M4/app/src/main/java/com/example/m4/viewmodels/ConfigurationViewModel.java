package com.example.m4.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;

/**
 * View model representing the configuration view the user starts in
 */
@SuppressWarnings("MagicNumber")
public class ConfigurationViewModel extends AndroidViewModel {

    private int score = 16;

    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    // getters and setters
    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }
}
