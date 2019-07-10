package com.example.m4.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import java.util.*;

public class TravelViewModel extends AndroidViewModel {

    private ArrayList<String> eventsList =
            new ArrayList<String>(Arrays.asList("Pirate Encounter"));
            //new ArrayList<String>(Arrays.asList("Trader Encounter", "Pirate Encounter", "Police Encounter", "Random Event", "Safe Travel"));

    private String randomElement;
    private boolean isitPirate = false;
    private boolean beatPirate;

    public TravelViewModel(@NonNull Application application) {
        super(application);
    }


    public String getRandomElement() {
        randomElement = eventsList.get(new Random().nextInt(eventsList.size()));
        if (randomElement.equals("Pirate Encounter")) {
            isitPirate = true;
        }
        return randomElement;
    }

    public boolean winningChancePirate() {
        int random = new Random().nextInt(2);
        if (random == 0) {
            beatPirate = true;
        } else {
            beatPirate = false;
        }
        return beatPirate;
    }

    public boolean getIsItPirate() {
        return  isitPirate;
    }

    public void setIsItPirate(boolean isitPirate) {
        this.isitPirate = isitPirate;
    }

}
