package com.example.m4.model;

public enum Resource {

    NOSPECIALRESOURCES("No Special Resource"), MINERALRICH("Mineral Rich"), MINERALPOOR("Mineral Poor"),
    DESERT("Desert"), LOTSOFWATER("Lots of Water"), RICHSOIL("Rich Soil"),
    POORSOIL("Poor Soil"), RICHFAUNA("Rich Fauna"), LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird Mushrooms"), LOTSOFHERBS("Lots of Herbs"),
    ARTISTIC("Artistic"), WARLIKE("Warlike");

    private String resource;

    Resource(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    @Override
    public String toString() {
        return resource;
    }
}
