package com.cs2340.spacetrader.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents the entire universe the game is set in
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "FeatureEnvy",
        "ChainedMethodCall", "AssignmentOrReturnOfFieldWithMutableType"})
public class Universe {

    //variables for a universe object
    private ArrayList<Region> regions = new ArrayList<>();
    private int numRegions;
    private int numPlanets;
    private final int HEIGHT = 150;
    private final int WIDTH = 100;
    private final int MIN_REGION_DISTANCE = 10;
    private final Random random;

    /**
     * Constructor setting up the number of regions and number of planets within the universe
     * @param numRegions of universe
     * @param numPlanets of universe
     */
    public Universe(int numRegions, int numPlanets) {

        if (numPlanets < numRegions) {
            throw new IllegalArgumentException("Number of planets cannot be" +
                    "less than number of regions.");
        }

        this.numRegions = numRegions;
        this.numPlanets = numPlanets;
        random = new Random();
    }

    /**
     * Populates the Universe by calling dropRegions(), then dropPlanets()
     */
    public void populate() {
        dropRegions(numRegions);
        Colors[] colors = Colors.values();
        int i = 0;
        for(Region region : regions) {
            region.setColor(colors[i]);
            region.addPlanet(new Planet(getUniquePlanetName(), region.getxLoc(), region.getyLoc()));
            i++;
        }
        dropPlanets(numPlanets);
    }

    /**
     * Overridden toString method
     * @return returns a string containing all the regions and planets within the universe
     */
    @Override
    @NonNull
    public String toString() {

        StringBuilder string = new StringBuilder("Universe: \n");
        for (Region region : regions) {
            string.append(region.getRegionName()).append(": ").
                    append(region.getSpecialResource()).append(", ").
                    append(region.getTechLevel()).append(",").
                    append(" (").append(region.getxLoc()).
                    append(", ").append(region.getyLoc()).
                    append("), ").append(region.getColor()).
                    append(region.getFuelneededtoTravel()).
                    append(" Planets: \n");
            for (Planet planet: region.getPlanetList()) {
                string.append(planet.getPlanetName()).
                        append(", (").append(planet.getxLocation()).
                        append(", ").append(planet.getyLocation()).
                        append(")\n");
            }
        }
        return string.toString();
    }

    /**
     * obtain Region
     * @return ArrayList<Region>
     */
    //getters and setters for the variables
    public Iterable<Region> getRegions() {
        return regions;
    }

    /**
     * set Region
     * @param regions ArrayList<Region>
     */
    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    /**
     * get Num regions
     * @return int of number of regions
     */
    public int getNumRegions() {
        return numRegions;
    }

    /**
     * set number of regions
     * @param numRegions int number of regions
     */
    public void setNumRegions(int numRegions) {
        this.numRegions = numRegions;
    }

    /**
     * get number of planets
     * @return int number of planets
     */
    public int getNumPlanets() {
        return numPlanets;
    }

    /**
     * set number of planets
     * @param numPlanets int number of planets
     */
    public void setNumPlanets(int numPlanets) {
        this.numPlanets = numPlanets;
    }

    /**
     * get height
     * @return height int
     */
    public int getHEIGHT() {
        return HEIGHT;
    }

    /**
     * get width
     * @return width int
     */
    public int getWIDTH() {
        return WIDTH;
    }

    //private helper methods are put here:

    /**
     * Drops a certain number of regions into the universe. This method
     * ensures that the regions are not too close together.
     * @param numRegions to drop
     */
    private void dropRegions(int numRegions) {

        for (int i = 0; i < numRegions; i++) {
            int[] location = getUniqueRegLocation();
            Region region = new Region(getUniqueRegion(), Resource.getRandom(),
                    TechLevel.getRandom(), location[0], location[1]);
            addRegion(region);
        }
    }

    /**
     * add region
     * adds a region object to the universe
     * @param region region
     */
    private void addRegion(Region region) {
        regions.add(region);
    }

    /**
     * is used region
     * this method checks if a RegionName has already been used
     * @param regionName region name
     * @return boolean is used
     */
    private boolean isUsedRegion(RegionName regionName) {

        for (Region region : regions) {
            if (region.getRegionName().equals(regionName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * get unique region
     * this method returns a RegionName that hasn't been used
     * @return region name
     */
    private RegionName getUniqueRegion() {

        RegionName temp = RegionName.getRandom();

        while(isUsedRegion(temp)) {
            temp = RegionName.getRandom();
        }

        return temp;
    }

    /**
     * get unique region location
     * return valid x and y coordinates for region
     * @return int array of locations
     */
    private int[] getUniqueRegLocation() {

        int tempX = random.nextInt(WIDTH);
        int tempY = random.nextInt(HEIGHT);

        while(!isValidRegLocation(tempX, tempY)) {
            tempX = random.nextInt(WIDTH);
            tempY = random.nextInt(HEIGHT);
        }

        return new int[]{tempX, tempY};

    }

    /**
     * is valid region location
     * checks if x and y coordinates are valid to create a region with
     * @param x int
     * @param y int
     * @return boolean is valid location
     */
    private boolean isValidRegLocation(int x, int y) {

        for (Region region : regions) {
            if (Math.hypot(region.getxLoc() - x, region.getyLoc() - y) < MIN_REGION_DISTANCE) {
                return false;
            }
        }
        return true;
    }

    /**
     * is used planet
     * @param planetName planetname
     * @return boolean is used
     */
    private boolean isUsedPlanet(PlanetName planetName) {
        for (Region region : regions) {
            for (Planet planet : region.getPlanetList()) {
                if (planet.getPlanetName().equals(planetName)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * get unique planet location
     * @return int array
     */
    private int[] getUniquePlanetLocation() {

        int tempX = random.nextInt(WIDTH);
        int tempY = random.nextInt(HEIGHT);
        while (!isValidPlanetLocation(tempX, tempY)) {
            tempX = random.nextInt(WIDTH);
            tempY = random.nextInt(HEIGHT);
        }

        return new int[]{tempX, tempY};
    }

    /**
     * is valid planet location
     * @param x int
     * @param y int
     * @return boolean is valid planet location
     */
    private boolean isValidPlanetLocation(int x, int y) {

        for (Region region : regions) {
            for (Planet planet : region.getPlanetList()) {
                if ((x == planet.getxLocation()) && (y == planet.getyLocation())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * get unique planet name
     * @return planetName
     */
    private PlanetName getUniquePlanetName() {

        PlanetName name = PlanetName.getRandom();
        while(!isUsedPlanet(name)) {
            name = PlanetName.getRandom();
        }
        return name;
    }

    /**
     * Drop planets into the universe. This method assigns each planet to
     * a region in the regions ArrayList based on proximity. Again, the
     * planets are not dropped completely randomly.
     * @param numPlanets number of planets to drop into the universe
     */
    private void dropPlanets(int numPlanets) {

        for (int i = 0; i < (numPlanets - numRegions); i++) {
            int[] location = getUniquePlanetLocation();
            Planet planet = new Planet(getUniquePlanetName(), location[0], location[1]);

            //find closest region
            Region closeRegion = regions.get(0);
            double distance = Math.hypot(closeRegion.getxLoc()
                    - planet.getxLocation(), closeRegion.getyLoc() - planet.getyLocation());
            for(Region region : regions) {
                double curr = Math.hypot(region.getxLoc()
                        - planet.getxLocation(), region.getyLoc() - planet.getyLocation());
                if (curr < distance) {
                    closeRegion = region;
                    distance = Math.hypot(closeRegion.getxLoc()
                            - planet.getxLocation(), closeRegion.getyLoc() - planet.getyLocation());
                }
            }

            int index = regions.indexOf(closeRegion);
            planet.setColor(regions.get(index).getColor());
            regions.get(index).addPlanet(planet);
        }

    }
}