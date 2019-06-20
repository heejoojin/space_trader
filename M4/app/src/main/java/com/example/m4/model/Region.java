package com.example.m4.model;

import java.util.ArrayList;

    /**
      * Represents a region of planets, defined using an ArrayList of Planet objects.
      * Constructor requires no parameters.
      */

public class Region {

    ArrayList<Planet> planetList = new ArrayList<>();
    int numPlanets;
    int xLoc;
    int yLoc;

    /**
     * Default constructor initializing all the variables
     */
    public Region () {
        numPlanets = 0;
        xLoc = 0;
        yLoc = 0;
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
    public int getNumPlanets() { return numPlanets; }

    public int getxLoc() { return xLoc; }

    public int getyLoc() { return yLoc; }

    public void setxLoc(int xLoc) { this.xLoc = xLoc; }

    public void setyLoc(int yLoc) { this.yLoc = yLoc; }


}
