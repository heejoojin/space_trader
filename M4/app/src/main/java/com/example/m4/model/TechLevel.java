package com.example.m4.model;

public enum TechLevel {

        PREAGRICULTURE("Pre-Agriculture"), AGRICULTURE("Agriculture"),
    MEDIEVAL("Medieval"), RENAISSANCE("Renaissance"), EARLYINDUSTRIAL("Early Industrial"),
    INDUSTRIAL("Industrial"), POSTINDUSTRIAL("Post-Industrial"),
    HITECH(" Hi-Tech");

    private final String rep;

    TechLevel(String rep) {
        this.rep = rep;
    }

}
