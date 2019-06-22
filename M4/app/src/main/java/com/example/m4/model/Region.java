package com.example.m4.model;

import java.util.ArrayList;

/**
 * Represents a region of planets, defined using an ArrayList of Planet objects.
 * Constructor requires no parameters.
 */

public class Region {

    private ArrayList<Planet> planetList = new ArrayList<>();
    private Colors color;
    private RegionName regionName;
    private Resource specialResource;
    private TechLevel techLevel;
    private int numPlanets;
    private int xLoc;
    private int yLoc;

    /**
     * Default constructor initializing all necessary variables
     */
    public Region(RegionName regionName, Resource specialResource, TechLevel techLevel, int xLoc, int yLoc) {
        this.regionName = regionName;
        this.specialResource = specialResource;
        this.techLevel = techLevel;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
    }

    /**
     * Adds a new planet to the ArrayList, also increments the number of planets the region has
     *
     * @param planet Planet to be added to the list
     */
    public void addPlanet(Planet planet) {
        planetList.add(planet);
        numPlanets++;
    }

    //Getters and setters for the variables

    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }

    public Resource getSpecialResource() {
        return specialResource;
    }

    public TechLevel getTechLevel() {
        return techLevel;
    }

    public int getNumPlanets() {
        return numPlanets;
    }

    public int getxLoc() {
        return xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setPlanetList(ArrayList<Planet> planetList) {
        this.planetList = planetList;
    }

    public void setSpecialResource(Resource specialResource) {
        this.specialResource = specialResource;
    }

    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    public void setNumPlanets(int numPlanets) {
        this.numPlanets = numPlanets;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public RegionName getRegionName() {
        return regionName;
    }

    public void setRegionName(RegionName regionName) {
        this.regionName = regionName;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }
}
