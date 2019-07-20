package com.example.m4.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomEventViewModel extends AndroidViewModel {

    private ArrayList<Integer> eventsList =
            //new ArrayList<String>(Arrays.asList("Pirate Encounter"));
            new ArrayList<>(Arrays.asList(0, 100, 200, 300, 400, 500));

    private boolean addCredits;

    public RandomEventViewModel(@NonNull Application application) {
        super(application);
    }

    public int getRandomElement() {
        int randomElement = eventsList.get(new Random().nextInt(eventsList.size()));
        return randomElement;
    }

    public boolean chanceGettingCredits() {
        int random = new Random().nextInt(2);
        addCredits = random == 0;
        return addCredits;
    }
}
