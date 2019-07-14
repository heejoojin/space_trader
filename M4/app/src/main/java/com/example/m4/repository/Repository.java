package com.example.m4.repository;
import android.content.Intent;

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
    public static ArrayList<Ship> shipList = new ArrayList<>();

    public static Boolean isitBuying = true;

    public static RegionName toTravelRegionName;
    public static ArrayList<Planet> toTravelPlanets;


    public static void setPlayerClass(Player p) {
        playerClass = p;
    }

    public static void setUniverseClass(Universe u) {
        universeClass = u;
    }

    public static void setRegionClass(Region r) {
        regionClass = r;
    }

    public static void setPlanetClass(Planet pl) {
        planetClass = pl;
    }

    public static void setItemsList(ArrayList<Item> il) {
        itemsList = il;
    }

    public static void setShipList(ArrayList<Ship> sl) {shipList = sl; }

    public static void setShipClass(Ship s) { shipClass = s; }

    public static void setToTravelRegionName(RegionName rn) { toTravelRegionName = rn; }
    public static void setToTravelPlanets(ArrayList<Planet> pls) { toTravelPlanets = pls; }


}
