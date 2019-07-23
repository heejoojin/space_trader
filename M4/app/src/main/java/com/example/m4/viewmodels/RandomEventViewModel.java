package com.example.m4.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * View model representing the random event view the user may encounter
 */
@SuppressWarnings("ALL")
public class RandomEventViewModel extends AndroidViewModel {

    private ArrayList<Integer> eventsList =
            //new ArrayList<String>(Arrays.asList("Pirate Encounter"));
            new ArrayList<>(Arrays.asList(0, 100, 200, 300, 400, 500));
    private ArrayList<String> itemName =
            new ArrayList<>(Arrays.asList("Water", "Furs", "Food",
                    "Ore", "Games", "Firearms", "Medicine", "Machines",
                    "Narcotics", "Robots"));

    private boolean addCredits;

    /**
     * Random event view model constructor with application parameter
     * @param application of configuration view
     */
    public RandomEventViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Selects a integer randomly from eventsList arrayList
     * @return random integer to be added or subtracted from the player's credits
     */
    public int getRandomCredit() {
        int randomElement = eventsList.get(new Random().nextInt(eventsList.size()));
        return randomElement;
    }

    /**
     * Selects a integer randomly to switch random event cases
     * @return random integer to select a random event case
     */
    public int getRandomChance() {
        return new Random().nextInt(4);
    }

    /**
     * Selects a condition whether the player is losing or gaining credits
     * @return true or false
     */
    public boolean getAddCredits() {
        int random = new Random().nextInt(2);
        addCredits = random == 0;
        return addCredits;
    }

    /**
     * Selects a random item to obtain
     * @return item name
     */
    public String findRandomItem() {
        String randomItem = itemName.get(new Random().nextInt(10));
        int num = Repository.itemMap.get(randomItem);

        num++;

        Repository.itemMap.put(randomItem, num);
        return randomItem;
    }

    /**
     * Selects a random item for the player to lose
     * @return item name
     */
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

    /**
     * Selects a random special weapon for the player
     * @return special weapon name
     */
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