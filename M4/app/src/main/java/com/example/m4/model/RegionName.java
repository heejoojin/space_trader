package com.example.m4.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum RegionName {
    //enum stuff here

    // Chose names randomly from the list of STAR TREK STUFF that our professor gave us
    ACAMAR("Acamar"), BALOSNEE("Balosnee"), CALONDIA("Calondia"), DALED("Daled"), ENDOR("Endor"), FROLIX("Frolix"),
    GEMULON("Gemulon"), HADES("Hades"), IRALIUS("Iralius"), JAPORI("Japori"), KLAATU("Klaatu"), LAVE("Lave");

    private final String region;


    RegionName(String region) {
        this.region = region;
    }

    public static RegionName getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return region;
    }
}
