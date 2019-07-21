package com.example.m4.viewmodels;

import android.app.Application;
import android.graphics.Paint;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RandomEventViewModel extends AndroidViewModel {

    private ArrayList<Integer> eventsList =
            //new ArrayList<String>(Arrays.asList("Pirate Encounter"));
            new ArrayList<>(Arrays.asList(0, 100, 200, 300, 400, 500));
    private ArrayList<String> itemName =
            new ArrayList<>(Arrays.asList("Water", "Furs", "Food",
                    "Ore", "Games", "Firearms", "Medicine", "Machines",
                    "Narcotics", "Robots"));

    private boolean addCredits;

    public RandomEventViewModel(@NonNull Application application) {
        super(application);
    }

    public int getRandomElement() {
        int randomElement = eventsList.get(new Random().nextInt(eventsList.size()));
        return randomElement;
    }

    public int getRandomChance() {
        return new Random().nextInt(4);
    }

    public boolean getAddCredits() {
        int random = new Random().nextInt(2);
        addCredits = random == 0;
        return addCredits;
    }

    public String findRandomItem() {
        String randomItem = itemName.get(new Random().nextInt(10));
        int num = Repository.itemMap.get(randomItem);

        num++;

        Repository.itemMap.put(randomItem, num);
        return randomItem;
    }

    public String loseRandomItem() {
        String randomItem = itemName.get(new Random().nextInt(3));
        // first three items

        if (Repository.itemMap.get(randomItem) > 0) {
            int num = Repository.itemMap.get(randomItem);
            num--;
            Repository.itemMap.put(randomItem, num);
            return randomItem;

        } else {
            return null;
        }
    }

    public String specialWeapon() {
        ArrayList<String> specialWeaponName =
                new ArrayList<>(Arrays.asList("Eclipse Plasma Gun",
                        "Energized Meson Gun",
                        "Multi-Shot Electron Zapper",
                        "Enhanced Thermal Gun",
                        "Energized Hand Sniper",
                        "Firestorm Ray Equalizer",
                        "Infused Proton Cannon",
                        "Meteor Plasma Shooter"));
        return specialWeaponName.get(new Random().nextInt(specialWeaponName.size()));
    }

}