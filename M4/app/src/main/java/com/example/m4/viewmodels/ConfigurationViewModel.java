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

    /**
     * Configuration view model constructor with application parameter
     * @param application of configuration view
     */
    public ConfigurationViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * set score method
     * @param score take score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * get score method
     * @return int of score
     */
    public int getScore() {
        return this.score;
    }
}
