package com.example.m4.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class that represents a single Mercenary object that can be hired or sold at the mercenary market
 */
@SuppressWarnings("FieldCanBeLocal")
public class Mercenary {

    private final ArrayList<String> weapons = new ArrayList<>(Arrays.asList("Assault Rifle", "Battle Rifle", "Sniper Rifle", "Energy Rifle", "Beam Rifle"));

    private String name;
    private boolean hired;
    private String weapon;
    private int price;

    /**
     * Constructor setting up name and weapon equipped
     * @param name name of mercenary
     */
    public Mercenary(String name, int price) {
        this.name = name;
        hired = false;
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
     * Setter for hired
     * @param hired true or false
     */
    public void setHired(boolean hired) { this.hired = hired; }
}
