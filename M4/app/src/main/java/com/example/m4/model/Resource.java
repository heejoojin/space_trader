package com.example.m4.model;

import java.util.*;

public enum Resource {

    NOSPECIALRESOURCES("No Special Resource"), MINERALRICH("Mineral Rich"), MINERALPOOR("Mineral Poor"),
    DESERT("Desert"), LOTSOFWATER("Lots of Water"), RICHSOIL("Rich Soil"),
    POORSOIL("Poor Soil"), RICHFAUNA("Rich Fauna"), LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird Mushrooms"), LOTSOFHERBS("Lots of Herbs"),
    ARTISTIC("Artistic"), WARLIKE("Warlike");

    private final String resource;

    Resource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    @Override
    public String toString() {
        return resource;
    }

    //this method returns a random resource
    public static Resource getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
