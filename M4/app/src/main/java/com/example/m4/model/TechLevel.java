package com.example.m4.model;

import java.util.*;

public enum TechLevel {

    PREAGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"), EARLYINDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"), POSTINDUSTRIAL("Post-Industrial"),
    HITECH(" Hi-Tech");

    private final String rep;

    TechLevel(String rep) {
        this.rep = rep;
    }

    //returns a random techlevel
    public static TechLevel getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return rep;
    }
}
