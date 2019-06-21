package com.example.m4.model;

public class Planet {

    private PlanetName planetName;
    private Colors color;
    private int xLocation;
    private int yLocation;
    private RegionName regionName;

    //constructors for a planet object

    public Planet(PlanetName planetName, Colors color, int xLocation, int yLocation, RegionName regionName) {
        this.planetName = planetName;
        this.color = color;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.regionName = regionName;
    }

    //getters and setters for the variable

    public PlanetName getPlanetName() {
        return planetName;
    }

    public Colors getColor() {
        return color;
    }

    public int getxLocation() {
        return xLocation;
    }

    public int getyLocation() {
        return yLocation;
    }

    public void setPlanetName(PlanetName planetName) {
        this.planetName = planetName;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }
}
