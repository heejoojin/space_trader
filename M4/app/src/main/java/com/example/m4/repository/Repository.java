package com.example.m4.repository;
<<<<<<< HEAD
<<<<<<< HEAD
=======
// import android.content.Intent;
>>>>>>> 225cdf6c8f2240a21bd3829c504d5359ca7108f0
=======
// import android.content.Intent;
>>>>>>> 225cdf6c8f2240a21bd3829c504d5359ca7108f0

import com.example.m4.model.Mercenary;
import com.example.m4.model.Player;
import com.example.m4.model.Planet;
import com.example.m4.model.Universe;
import com.example.m4.model.Region;
import com.example.m4.model.Item;
import com.example.m4.model.RegionName;
import com.example.m4.model.Ship;
import java.util.*;

public class Repository {

    public static Player playerClass;
    public static Universe universeClass;
    public static Region regionClass;
    public static Planet planetClass;
    public static Ship shipClass;

    public static ArrayList<Item> itemsList = new ArrayList<>();
    public static ArrayList<Mercenary> mercenariesList = new ArrayList<>();
    public static ArrayList<Ship> shipList = new ArrayList<>();

    public static Boolean isitBuying = true;

    public static RegionName toTravelRegionName;
    public static ArrayList<Planet> toTravelPlanets;


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
    public static void setItemsList(ArrayList<Item> il) {
        itemsList = il;
    }

    /**
     * set Mercenaries List
     * @param ml ArrayList of mercenaries
     */
    public static void setMercenariesList(ArrayList<Mercenary> ml) { mercenariesList = ml; }

    /**
     * set Ship List
     * @param sl arraylist of ships
     */
    public static void setShipList(ArrayList<Ship> sl) {shipList = sl; }

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
    public static void setToTravelPlanets(ArrayList<Planet> pls) { toTravelPlanets = pls; }

}
