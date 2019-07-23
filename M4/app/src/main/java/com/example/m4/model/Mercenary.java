package com.example.m4.model;

import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class that represents a single Mercenary object that can be hired or sold at the mercenary market
 */
@SuppressWarnings("ALL")
public class Mercenary {

    private final ArrayList<String> weapons =
            new ArrayList<>(Arrays.asList("Assault Rifle", "Battle Rifle",
                    "Sniper Rifle", "Energy Rifle", "Beam Rifle"));

    private final String name;
    private boolean hired;
    private final String weapon;
    private final int price;
    private int quantityChange;

    /**
     * Constructor setting up name and weapon equipped
     * @param name name of mercenary
     * @param price price of Mercenary
     * @param isithired whether the mecenary is hired or not
     */
    public Mercenary(String name, int price, String isithired) {
        this.name = name;
        if (isithired.equals("NOT HIRED")) {
            hired = false;
        } else {
            hired = true;
        }
        weapon = weapons.get(new Random().nextInt(weapons.size()));
        this.price = price;
    }

    /**
     * Getter for name
     * @return name
     */
    public String getName() { return name; }

    /**
     * Getter for hired
     * @return true or false
     */
    public boolean getHired() { return hired; }

    /**
     * Getter for weapon
     * @return weapon
     */
    public String getWeapon() { return weapon; }

    /**
     * Getter for price
     * @return price
     */
    public int getPrice() { return price; }

    /**
     * Getter for change in mercenary quantity
     * @return quantity changed;
     */
    public int getQuantityChange() { return quantityChange; }

    /**
     * Setter for change in mercenary quantity
     * @param quantityChange change in mercenary quantity
     */
    public void setQuantityChange(int quantityChange) {
        this.quantityChange = quantityChange;
    }

    /**
     * Setter for hired
     * @param hired true or false
     */
    public void setHired(boolean hired) {
        this.hired = hired;
        if (hired == true) {
            Repository.mercenaryMap.put(name, "HIRED");
        } else {
            Repository.mercenaryMap.put(name, "NOT HIRED");
        }
    }
}
