package com.example.m4.model;

import java.util.ArrayList;

/**
 * Represents a region of planets, defined using an ArrayList of Planet objects.
 * Constructor requires no parameters.
 */

@SuppressWarnings("unused")
public class Region {

    private ArrayList<Planet> planetList = new ArrayList<>();
    private Colors color;
    private RegionName regionName;
    private Resource specialResource;
    private TechLevel techLevel;
    private int numPlanets;
    private int xLoc;
    private int yLoc;
    private int fuelneededtoTravel;

    /**
     * Default constructor initializing all necessary variables
     */
    public Region(RegionName regionName, Resource specialResource, TechLevel techLevel, int xLoc, int yLoc) {
        this.regionName = regionName;
        this.specialResource = specialResource;
        this.techLevel = techLevel;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.fuelneededtoTravel = (200000 + (int)(Math.random() * (1000000 - 200000)));
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

    /**
     * get Planet List
     * @return arraylist of planets
     */
    public ArrayList<Planet> getPlanetList() {
        return planetList;
    }

    /**
     * get special resource
     * @return resource
     */
    public Resource getSpecialResource() {
        return specialResource;
    }

    /**
     * get tech level
     * @return techlevel
     */
    public TechLevel getTechLevel() {
        return techLevel;
    }

    /**
     * get number of planets
     * @return int number of planets
     */
    public int getNumPlanets() {
        return numPlanets;
    }

    /**
     * get xlocation
     * @return int x location
     */
    public int getxLoc() {
        return xLoc;
    }

    /**
     * get yLocation
     * @return int ylocation
     */
    public int getyLoc() {
        return yLoc;
    }

    /**
     * get fuel needed to travel
     * @return int fuel needed to travel
     */
    public int getFuelneededtoTravel() { return fuelneededtoTravel; }

    /**
     * set planet list
     * @param planetList arraylist of planets
     */
    public void setPlanetList(ArrayList<Planet> planetList) {
        this.planetList = planetList;
    }

    /**
     * set special resource
     * @param specialResource recource
     */
    public void setSpecialResource(Resource specialResource) {
        this.specialResource = specialResource;
    }

    /**
     * set tech level
     * @param techLevel techlevel
     */
    public void setTechLevel(TechLevel techLevel) {
        this.techLevel = techLevel;
    }

    /**
     * set num planets
     * @param numPlanets int numplanets
     */
    public void setNumPlanets(int numPlanets) {
        this.numPlanets = numPlanets;
    }

    /**
     * set xlocation
     * @param xLoc int
     */
    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    /**
     * set y location
     * @param yLoc int
     */
    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    /**
     * set Fuel needed to travel
     * @param fuelneededtoTravel int
     */
    public void setFuelneededtoTravel(int fuelneededtoTravel) {
        this.fuelneededtoTravel = fuelneededtoTravel;
    }

    /**
     * get region name
     * @return regionName
     */
    public RegionName getRegionName() {
        return regionName;
    }

    /**
     * set Region name
     * @param regionName region name
     */
    public void setRegionName(RegionName regionName) {
        this.regionName = regionName;
    }

    /**
     * get color
     * @return color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * set color
     * @param color color
     */
    public void setColor(Colors color) {
        this.color = color;
    }
}
