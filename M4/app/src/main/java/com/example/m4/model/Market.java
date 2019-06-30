package com.example.m4.model;
import android.util.Log;

import java.util.*;
import com.example.m4.repository.Repository;
import com.example.m4.model.Item;

public class Market {

    public static ArrayList<String> itemList = new ArrayList<>(Arrays.asList("Water", "Furs", "Food", "Ore", "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots"));
    public static ArrayList<Integer> itemPrice = new ArrayList<>(Arrays.asList(30, 250, 100, 350, 250, 1250, 650, 900, 3500, 5000));

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

    //getters and setters for fields
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

}
