package com.example.m4.model;

import androidx.annotation.NonNull;

import java.util.Random;

/**
 * Enumerated class that sets up the tech level
 */
public enum TechLevel {

    PRE_AGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"), EARLY_INDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"), POSTINDUSTRIAL("Post-Industrial"),
    HI_TECH(" Hi-Tech");

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
    @NonNull
    public String toString() {
        return rep;
    }
}
