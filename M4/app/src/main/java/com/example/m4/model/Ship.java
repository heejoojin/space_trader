package com.example.m4.model;

import java.util.ArrayList;

public class Ship {



    private String name;
    private int numWater;
    private int numFurs;
    private int numFood;
    private int numOre;
    private int numGames;
    private int numFirearms;
    private int numMedicine;
    private int numMachines;
    private int numNarcotics;
    private int numRobots;

    /**
     * Constructor
     * @param name name of the ship
     */
    public Ship(String name) {
        this.name = name;
    }

    //getters and setters
    public int getNumWater() { return numWater; }
    public int getNumFurs() { return numFurs; }
    public int getNumFood() { return numFood; }
    public int getNumOre() { return numOre; }
    public int getNumGames() { return numGames; }
    public int getNumFirearms() { return numFirearms; }
    public int getNumMedicine() { return numMedicine; }
    public int getNumMachines() { return numMachines; }
    public int getNumNarcotics() { return numNarcotics; }
    public int getNumRobots() { return numRobots; }
    public String getName() { return name; }

    public void setNumWater(int numWater) { this.numWater = numWater; }
    public void setNumFurs(int numFurs) { this.numFurs = numFurs; }
    public void setNumFood(int numFood) { this.numFood = numFood; }
    public void setNumOre(int numOre) { this.numOre = numOre; }
    public void setNumGames(int numGames) { this.numGames = numGames; }
    public void setNumFirearms(int numFirearms) { this.numFirearms = numFirearms; }
    public void setNumMedicine(int numMedicine) { this.numMedicine = numMedicine; }
    public void setNumMachines(int numMachines) { this.numMachines = numMachines; }
    public void setNumNarcotics(int numNarcotics) { this.numNarcotics = numNarcotics; }
    public void setNumRobots(int numRobots) { this.numRobots = numRobots; }
    public void setName(String name) { this.name = name; }
}
