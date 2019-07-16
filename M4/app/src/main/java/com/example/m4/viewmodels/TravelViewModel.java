package com.example.m4.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import java.util.*;

/**
 * View model representing the different events we could encounter whilst traveling
 */
@SuppressWarnings("FieldCanBeLocal")
public class TravelViewModel extends AndroidViewModel {

    private ArrayList<String> eventsList =
            //new ArrayList<String>(Arrays.asList("Pirate Encounter"));
            new ArrayList<>(Arrays.asList("Trader Encounter", "Pirate Encounter", "Police Encounter", "Random Event", "Safe Travel"));

    private boolean isitPirate = false;
    private boolean beatPirate;

    public TravelViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Obtains a random event from the list
     * @return the random event
     */
    public String getRandomElement() {
        String randomElement = eventsList.get(new Random().nextInt(eventsList.size()));
        if (randomElement.equals("Pirate Encounter")) {
            isitPirate = true;
        }
        return randomElement;
    }

    /**
     * Sets up the difficulty in beating the pirate
     * @return whether the pirate can be beaten or not
     */
    public boolean winningChancePirate() {
        int random = new Random().nextInt(2);
        if (random == 0) {
            beatPirate = true;
        } else {
            beatPirate = false;
        }
        return beatPirate;
    }

    // getter and setter
    public boolean getIsItPirate() {
        return  isitPirate;
    }

    public void setIsItPirate(boolean isitPirate) {
        this.isitPirate = isitPirate;
    }

}
