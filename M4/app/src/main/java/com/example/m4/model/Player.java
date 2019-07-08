package com.example.m4.model;
import java.util.*;

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

    private Difficulty difficulty;

    private int fuel;

    public Player(String name, int pilotPoints, int fighterPoints, int traderPoints, int engineerPoints) {
        this.credits = 1000;
        this.name = name;
        this.pilotPoints = pilotPoints;
        this.fighterPoints = fighterPoints;
        this.traderPoints = traderPoints;
        this.engineerPoints = engineerPoints;
        this.ship = "Gnat Spaceship";
        this.fuel = 1203760;
    }

    //Getters and setters required for accessing the fields

    public int getFuel() { return this.fuel; }

    public int getCredits() { return this.credits; }

    public int getPilotPoints() { return this.pilotPoints; }

    public int getFighterPoints() { return this.fighterPoints; }

    public int getTraderPoints() { return this.traderPoints; }

    public int getEngineerPoints() {return this.engineerPoints; }

    public String getName() {return this.name; }

    public String getShip() {return this.ship;}

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

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

    public void setShip(String ship) {
        this.ship = ship;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setFuel(int fuel) { this.fuel = fuel; }


}