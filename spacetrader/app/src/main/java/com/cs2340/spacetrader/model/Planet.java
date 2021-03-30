package com.cs2340.spacetrader.model;




/**
 * Planet class that represents a singular planet within a Region. Contains its coordinates within
 * the region as well as various other essential variables
 */

@SuppressWarnings("unused")
public class Planet {

    private PlanetName planetName;
    private Colors color;
    private int xLocation;
    private int yLocation;
    // private int fuel;

    //constructors for a planet object

    /**
     * Planet constructor
     * @param planetName planet name
     * @param xLocation int
     * @param yLocation int
     */
    public Planet(PlanetName planetName, int xLocation, int yLocation) {
        this.planetName = planetName;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
//        this.fuel = (10000 + (int)(Math.random() * (30000 - 10000)));
    }

    //getters and setters for the variable

    /**
     * get planet name
     * @return planet name
     */
    public PlanetName getPlanetName() {
        return planetName;
    }

    /**
     * get color
     * @return color
     */
    public Colors getColor() {
        return color;
    }

    /**
     * get xlocation
     * @return xLocation
     */
    public int getxLocation() {
        return xLocation;
    }

    /**
     * get yLocation
     * @return yLocation
     */
    public int getyLocation() {
        return yLocation;
    }

    /**
     * set planetname
     * @param planetName planet name from enum
     */
    public void setPlanetName(PlanetName planetName) {
        this.planetName = planetName;
    }

    /**
     * set color method
     * @param color color enum
     */
    public void setColor(Colors color) {
        this.color = color;
    }

    /**
     * set xLocation
     * @param xLocation int
     */
    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    /**
     * set ylocation
     * @param yLocation int
     */
    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

//    public int getFuel() { return this.fuel; }
//
//    public void setFuel(int fuel) { this.fuel = fuel; }

}
