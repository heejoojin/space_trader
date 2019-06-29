package com.example.m4.repository;
import com.example.m4.model.Player;
import com.example.m4.model.Planet;
import com.example.m4.model.Universe;
import com.example.m4.model.Region;

import java.util.*;

public class Repository {

    public static Player playerClass;
    public static Universe universeClass;
    public static Region regionClass;
    public static Planet planetClass;

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

}
