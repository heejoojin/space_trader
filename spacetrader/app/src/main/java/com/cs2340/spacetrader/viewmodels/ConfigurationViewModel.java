package com.cs2340.spacetrader.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;

import com.cs2340.spacetrader.repository.Repository;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * View model representing the configuration view the user starts in
 */
@SuppressWarnings("ALL")
public class ConfigurationViewModel extends AndroidViewModel {

    private int score = 16;
    private DatabaseReference databaseReference;


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

    /**
     * store the new user's info in Google Firebase realtime database
     *
     */
    public void fireBase() {

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.push().child("user").child("name").setValue(Repository.playerClass.getName());
    }
}
