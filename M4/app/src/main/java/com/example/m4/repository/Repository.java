package com.example.m4.repository;
import com.example.m4.model.Mercenary;
import com.example.m4.model.Player;
import com.example.m4.model.Planet;
import com.example.m4.model.Universe;
import com.example.m4.model.Region;
import com.example.m4.model.Item;
import com.example.m4.model.RegionName;
import com.example.m4.model.Ship;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
//@SuppressWarnings({"WeakerAccess", "unused",
//        "PublicField", "AssignmentOrReturnOfFieldWithMutableType",
//        "UtilityClass", "ClassWithTooManyDependents"})

/**
 * Repository class that stores the player's information
 */
public class Repository {

    public static Player playerClass;
    public static Universe universeClass;
    public static Region regionClass;
    public static Planet planetClass;
    public static Ship shipClass;

    public static List<Item> itemsList = new ArrayList<>();
    public static List<Mercenary> mercenariesList = new ArrayList<>();
    public static List<Ship> shipList = new ArrayList<>();

    public static Boolean isitBuying = true;
    public static Boolean transactionHistory = false;

    public static RegionName toTravelRegionName;
    public static Iterable<Planet> toTravelPlanets;

    public static HashMap<String, Integer> itemMap = new HashMap<>();
    public static HashMap<String, String> mercenaryMap = new HashMap<>();

    /**
     * set Player Class method
     * @param p player Class
     */
    public static void setPlayerClass(Player p) {
        playerClass = p;
    }

    /**
     * set Universe Class
     * @param u universe
     */
    public static void setUniverseClass(Universe u) {
        universeClass = u;
    }

    /**
     * set Region class
     * @param r region
     */
    public static void setRegionClass(Region r) {
        regionClass = r;
    }

    /**
     * set Planet class
     * @param pl planet
     */
    public static void setPlanetClass(Planet pl) {
        planetClass = pl;
    }

    /**
     * set Items list
     * @param il ArrayList of Items
     */
    public static void setItemsList(List<Item> il) {
        itemsList = il;
    }

    /**
     * set Mercenaries List
     * @param ml ArrayList of mercenaries
     */
    public static void setMercenariesList(List<Mercenary> ml) { mercenariesList = ml; }

    /**
     * set Ship List
     * @param sl arraylist of ships
     */
    public static void setShipList(List<Ship> sl) {shipList = sl; }

    /**
     * set Ship Class
     * @param s ship
     */
    public static void setShipClass(Ship s) { shipClass = s; }

    /**
     * set toTravel region name
     * @param rn region name
     */
    public static void setToTravelRegionName(RegionName rn) { toTravelRegionName = rn; }


    /**
     * set toTravel planets
     * @param pls arraylist of planets
     */
    public static void setToTravelPlanets(Iterable<Planet> pls) { toTravelPlanets = pls; }

    /**
     * save the quantity of each item owned in cargo using Hashmap
     */
    public static void saveItemMap() {
        ArrayList<String> itemName =
                new ArrayList<>(Arrays.asList("Water", "Furs", "Food",
                        "Ore", "Games", "Firearms", "Medicine", "Machines",
                        "Narcotics", "Robots"));
        for (int i=0; i < itemName.size(); i++) {
            itemMap.put(itemName.get(i), 0);
        }
    }

    /**
     * save the quantity of each mercenary owned in cargo using Hashmap
     */
    public static void saveMercenaryMap() {
        ArrayList<String> mercenaryName =
                new ArrayList<>(Arrays.asList("Red", "Heejoo", "Nina",
                        "Brian", "Kunhyuk", "John", "Spock",
                        "Jango Fett", "Deadpool", "Boba Fett"));

        for (int i=0; i < mercenaryName.size(); i++) {
            mercenaryMap.put(mercenaryName.get(i), "NOT HIRED");
        }
    }
    /**
     * set whether or not the user have had any transactions in the market
     * @param h boolean to check any transaction history
     */
    public static void setTransactionHistory(boolean h) {
        transactionHistory = h;
    }

}
