package com.example.m4.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.m4.repository.Repository;
import com.example.m4.views.RandomEventView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * View model representing the different events we could encounter whilst traveling
 */
@SuppressWarnings({"FieldCanBeLocal", "ChainedMethodCall"})
public class TravelViewModel extends AndroidViewModel {

    private final ArrayList<String> eventsList =
            //new ArrayList<>(Arrays.asList("Random Event"));
            new ArrayList<>(Arrays.asList("Trader Encounter", "Pirate Encounter",
                    "Police Encounter", "Random Event", "Safe Travel"));

    private boolean isitPirate;
    private boolean beatPirate;

    private boolean isitTrader;

    /**
     * Constructor with single parameter
     * @param application of TravelView
     */
    public TravelViewModel(@NonNull Application application) {
        super(application);
    }

    /**
     * Obtains a random event from the list
     * @return the random event
     */
    public String getRandomElement() {
        String randomElement = eventsList.get(new Random().nextInt(eventsList.size()));
        if ("Pirate Encounter".equals(randomElement)) {
            isitPirate = true;
        } else if ("Trader Encounter".equals(randomElement)) {
            isitTrader = true;
        }
        return randomElement;
    }

    /**
     * Sets up the difficulty in beating the pirate
     * @return whether the pirate can be beaten or not
     */
    public boolean winningChancePirate() {
        int random = new Random().nextInt(2);
        beatPirate = random == 0;
        return beatPirate;
    }

    /**
     * Getter method for IsItPirate
     * @return true if it is pirate
     */
    public boolean getIsItPirate() {
        return  isitPirate;
    }

    /**
     * Getter method for IsItTrader
     * @return true if it is trader
     */
    public boolean getIsItTrader() {
        return  isitTrader;
    }

    /**
     * Setter method for isItPirate
     * @param isitPirate isItPirate
     */
    public void setIsItPirate(boolean isitPirate) {
        this.isitPirate = isitPirate;
    }

    public String[] tradeGoods() {
        String[] arr = new String[2];
        ArrayList<String> itemName =
                new ArrayList<>(Arrays.asList("Water", "Furs", "Food",
                        "Ore", "Games", "Firearms", "Medicine", "Machines",
                        "Narcotics", "Robots"));


        for (int i = 0; i < 10; i++) {

            String item = itemName.get(i);
            String randomElement = itemName.get(new Random().nextInt(10));

            int num1 = Repository.itemMap.get(item);

            if (num1 > 0 &&
                    !item.equals(randomElement)) {
                arr[0] = item;
                arr[1] = randomElement;

                num1--;

                int num2 = Repository.itemMap.get(randomElement);
                num2++;

                Repository.itemMap.put(item, num1);
                Repository.itemMap.put(randomElement, num2);
            }
        }
        return arr;

    }

}
