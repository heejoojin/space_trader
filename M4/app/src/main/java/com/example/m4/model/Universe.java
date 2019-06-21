package com.example.m4.model;

import java.util.ArrayList;

public class Universe {

    //variables for a universe object
    private ArrayList<Region> regions = new ArrayList<>();
    private int numRegions;
    private int numPlanets;

    //adds a region object to the universe
    public void addRegion(Region region) {
        regions.add(region);
        numRegions++;
    }

    //constructs a Universe object
    public Universe(int numRegions, int numPlanets) {
        this.numRegions = numRegions;
        this.numPlanets = numPlanets;
    }

    //populates the Universe by calling dropRegions(), then dropPlanets()
    public void populate() {
        dropRegions(numRegions);
        dropPlanets(numPlanets);
    }

    /**
     * Drops a certain number of regions into the universe. This method is
     * not completely random. This is to ensure that there won't be a bad
     * universe created (the regions are too unevenly distributed)
     * @param numRegions
     */
    private void dropRegions(int numRegions) {}

    /**
     * Drop planets into the universe. This method assigns each planet to
     * a region in the regions ArrayList based on proximity. Again, the
     * planets are not dropped completely randomly.
     * @param numPlanets number of planets to drop into the universe
     */
    private void dropPlanets(int numPlanets) {}

    //getters and setters for the variables
    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

}
