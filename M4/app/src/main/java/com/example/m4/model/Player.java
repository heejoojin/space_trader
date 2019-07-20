package com.example.m4.model;
/**
 * This class represents a player object
 */
public class Player {

    /** this player's credits */
    private int credits;

    /** this player's pilot skill points */
    private int pilotPoints;

    /** this player's fighter skill points */
    private int fighterPoints;

    /** this player's trader skill points */
    private int traderPoints;

    /** this player's trader skill points */
    private int engineerPoints;

    /** this player's name */
    private String name;

    /** this player's ship */
    private String ship;

    private String weapons;

    private Difficulty difficulty;

    private int fuel;

    /**
     * Constructor that sets up the inital player information
     * @param name name of the player
     * @param pilotPoints number of points the user put into pilot
     * @param fighterPoints number of points the user put into fighter
     * @param traderPoints number of points the user put into trader
     * @param engineerPoints number of points the user put into engineer
     */
    public Player(String name, int pilotPoints, int fighterPoints,
                  int traderPoints, int engineerPoints) {
        if ((pilotPoints + fighterPoints
                + traderPoints + engineerPoints) >16) {
            throw new IllegalArgumentException("Total skill points"
                    + "cannot exceed 16");
        }
        this.credits = 1000;
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = "Gnat";
        this.weapons = "None";
        this.fuel = 3203760;
    }

    //Getters and setters required for accessing the fields

    /**
     * get Fuel
     * @return int of fuel
     */
    public int getFuel() { return this.fuel; }

    /**
     * get Credits
     * @return int of credits
     */
    public int getCredits() { return this.credits; }

    /**
     * get Pilot Points
     * @return int pilot points
     */
    public int getPilotPoints() { return this.pilotPoints; }

    /**
     * get Fighter Points
     * @return int fighter Points
     */
    public int getFighterPoints() { return this.fighterPoints; }

    /**
     * get Trader Points
     * @return int trader points
     */
    public int getTraderPoints() { return this.traderPoints; }

    /**
     * get engineer points
     * @return int engineer points
     */
    public int getEngineerPoints() {return this.engineerPoints; }

    /**
     * get Name
     * @return string of name
     */
    public String getName() {return this.name; }

    /**
     * get ship
     * @return string of ship
     */
    public String getShip() {return this.ship;}

    /**
     * get weapons level
     * @return string weapons level
     */
    public String getWeapons() {return this.weapons;}

    /**
     * get difficulty
     * @return Difficulty enum
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * set credits
     * @param credits int
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * set pilot points
     * @param pilotPoints int
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * set Fighter Points
     * @param fighterPoints int
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * set trader points
     * @param traderPoints int
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * set engineer points
     * @param engineerPoints int
     */
    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    /**
     * set name
     * @param name string of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set ship
     * @param ship string of ship
     */
    public void setShip(String ship) {
        this.ship = ship;
    }

    /**
     * set weapons level
     * @param weapons string weapons level
     */
    public void setWeapons(String weapons) {this.weapons = weapons;}

    /**
     * set difficulty
     * @param difficulty Difficulty enum
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * set Fuel
     * @param fuel int of fuel
     */
    public void setFuel(int fuel) { this.fuel = fuel; }


}