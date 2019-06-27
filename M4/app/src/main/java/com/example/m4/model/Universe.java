package com.example.m4.model;

import java.util.ArrayList;
import java.util.Random;

public class Universe {

    //variables for a universe object
    private ArrayList<Region> regions = new ArrayList<>();
    private int numRegions;
    private int numPlanets;
    private final int HEIGHT = 150;
    private final int WIDTH = 100;
    private final int MINREGIONDISTANCE = 10;
    private Random random;

    public static ArrayList<Planet> temp_planets = new ArrayList<>();

    //constructs a Universe object
    public Universe(int numRegions, int numPlanets) {

        if (numPlanets < numRegions) {
            throw new IllegalArgumentException("Number of planets cannot be less than number of regions.");
        }

        this.numRegions = numRegions;
        this.numPlanets = numPlanets;
        random = new Random();
    }

    //populates the Universe by calling dropRegions(), then dropPlanets()
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

    @Override
    public String toString() {

        String string = "Universe: \n";
        for (Region region : regions) {
            string += region.getRegionName() + ": " + region.getSpecialResource()
                    + ", " + region.getTechLevel() + "," + " (" + region.getxLoc()
                    + ", " + region.getyLoc() + "), " + region.getColor() + " Planets: \n";
            for (Planet planet: region.getPlanetList()) {
                string += planet.getPlanetName() + ", (" + planet.getxLocation()
                        + ", " + planet.getyLocation() + ")\n";
            }
        }
        return string;
    }

    //getters and setters for the variables
    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    public int getNumRegions() {
        return numRegions;
    }

    public void setNumRegions(int numRegions) {
        this.numRegions = numRegions;
    }

    public int getNumPlanets() {
        return numPlanets;
    }

    public void setNumPlanets(int numPlanets) {
        this.numPlanets = numPlanets;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    //private helper methods are put here:

    /**
     * Drops a certain number of regions into the universe. This method
     * ensures that the regions are not too close together.
     * @param numRegions
     */
    private void dropRegions(int numRegions) {

        for (int i = 0; i < numRegions; i++) {
            int[] location = getUniqueRegLocation();
            Region region = new Region(getUniqueRegion(), Resource.getRandom(),
                    TechLevel.getRandom(), location[0], location[1]);
            addRegion(region);
        }
    }

    //adds a region object to the universe
    private void addRegion(Region region) {
        regions.add(region);
    }

    //this method checks if a RegionName has already been used
    private boolean isUsedRegion(RegionName regionName) {

        for (Region region : regions) {
            if (region.getRegionName().equals(regionName)) {
                return true;
            }
        }
        return false;
    }

    //this method returns a RegionName that hasn't been used
    private RegionName getUniqueRegion() {

        RegionName temp = RegionName.getRandom();

        while(isUsedRegion(temp)) {
            temp = RegionName.getRandom();
        }

        return temp;
    }

    //return valid x and y coordinates for region
    private int[] getUniqueRegLocation() {

        int tempX = random.nextInt(WIDTH);
        int tempY = random.nextInt(HEIGHT);

        while(!isValidRegLocation(tempX, tempY)) {
            tempX = random.nextInt(WIDTH);
            tempY = random.nextInt(HEIGHT);
        }

        return new int[]{tempX, tempY};

    }

    //checks if x and y coordinates are valid to create a region with
    private boolean isValidRegLocation(int x, int y) {

        for (Region region : regions) {
            if (Math.hypot(region.getxLoc() - x, region.getyLoc() - y) < MINREGIONDISTANCE) {
                return false;
            }
        }
        return true;
    }

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

    private int[] getUniquePlanetLocation() {

        int tempX = random.nextInt(WIDTH);
        int tempY = random.nextInt(HEIGHT);
        while (!isValidPlanetLocation(tempX, tempY)) {
            tempX = random.nextInt(WIDTH);
            tempY = random.nextInt(HEIGHT);
        }

        return new int[]{tempX, tempY};
    }

    private boolean isValidPlanetLocation(int x, int y) {

        for (Region region : regions) {
            for (Planet planet : region.getPlanetList()) {
                if (x  == planet.getxLocation() && y == planet.getyLocation()) {
                    return false;
                }
            }
        }
        return true;
    }

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
            regions.get(index).addPlanet(planet);
        }

    }
}