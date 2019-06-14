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

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints) {
        this.credits = 1000;
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
    }

    //Getters and setters required for accessing the fields

    public int getCredits() { return credits; }

    public int getPilotPoints() { return pilotPoints; }

    public int getFighterPoints() { return fighterPoints; }

    public int getTraderPoints() { return traderPoints; }

    public int getEngineerPoints() {return engineerPoints; }

    public String getName() {return name; }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public void setName(String name) {
        this.name = name;
    }
}