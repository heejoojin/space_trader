package com.example.m4.model;

// import com.example.m4.repository.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Class representing the player's ship, containing variables such as the items owned
 */
public class Ship {

    private String name;
    private ArrayList<String> weapons = new ArrayList<>(Arrays.asList("Pulse laser", "Beam laser", "Military laser", "No weapon"));
    private ArrayList<String> shields = new ArrayList<>(Arrays.asList("Energy shield", "Reflective shield", "No shield"));
    private ArrayList<String> gadgets = new ArrayList<>(Arrays.asList("Navigation system", "Auto-repair system", "Targeting System", "No gadget"));
    private ArrayList<String> escape_pods = new ArrayList<>(Arrays.asList("Escape pod", "No escape pod"));
    private ArrayList<String> insurances = new ArrayList<>(Arrays.asList("Insurance", "No insurance"));

    private String weapon;
    private String shield;
    private String gadget;
    private String escape_pod;
    private String insurance;

    /**
     * Constructor setting up the name of the ship and the price within the market
     * @param name name of the ship
     */
    public Ship(String name) {
        this.name = name;
        this.weapon = weapons.get(new Random().nextInt(weapons.size()));
        this.shield = shields.get(new Random().nextInt(shields.size()));
        this.gadget = gadgets.get(new Random().nextInt(gadgets.size()));
        this.escape_pod = escape_pods.get(new Random().nextInt(escape_pods.size()));
        this.insurance = insurances.get(new Random().nextInt(insurances.size()));
    }

    // getters and setters

    /**
     * get Name
     * @return String of name
     */
    public String getName() {
        return name;
    }

    /**
     * get weapon
     * @return String of weapon
     */
    public String getWeapon() {
        return weapon;
    }

    /**
     * get Shield
     * @return String of sheild
     */
    public String getShield() {
        return shield;
    }

    /**
     * get Gadget
     * @return String of gadget
     */
    public String getGadget() {
        return gadget;
    }

    /**
     * get Escape Pod
     * @return String of escape pod
     */
    public String getEscapePod() {
        return escape_pod;
    }

    /**
     * get Insurance
     * @return String of insurance
     */
    public String getInsurance() {
        return insurance;
    }

}
