package com.example.m4.model;

import androidx.annotation.NonNull;

import java.util.Random;

/**
 * Enumerated class that represents the resource level
 */
public enum Resource {

    NOSPECIALRESOURCES("No Special Resource"),
    MINERALRICH("Mineral Rich"), MINERALPOOR("Mineral Poor"),
    DESERT("Desert"), LOTSOFWATER("Lots of Water"), RICHSOIL("Rich Soil"),
    POORSOIL("Poor Soil"), RICHFAUNA("Rich Fauna"), LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird Mushrooms"), LOTSOFHERBS("Lots of Herbs"),
    ARTISTIC("Artistic"), WARLIKE("Warlike");

    private final String resource;

    /**
     * Constructor setting up the resource level
     * @param resource of enum string
     */
    Resource(String resource) {
        this.resource = resource;
    }

//    public String getResource() {
//        return resource;
//    }

    /**
     * Overridden toString method
     * @return the resource level
     */
    @Override
    @NonNull
    public String toString() {
        return resource;
    }

    /**
     * Obtains a random resource level from the list
     * @return the obtained resource level
     */
    public static Resource getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
