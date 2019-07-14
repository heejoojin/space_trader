package com.example.m4.model;

import java.util.*;

/**
 * Enumerated class that sets up the tech level
 */
public enum TechLevel {

    PREAGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"), EARLYINDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"), POSTINDUSTRIAL("Post-Industrial"),
    HITECH(" Hi-Tech");

    private final String rep;

    /**
     * Constructor that sets up the tech level for the region/planet
     */
    TechLevel(String rep) {
        this.rep = rep;
    }

    /**
     * Obtains a random tech level from the list
     * @return the obtained tech level
     */
    public static TechLevel getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    /**
     * Overridden toString method
     * @return the tech level
     */
    @Override
    public String toString() {
        return rep;
    }
}
