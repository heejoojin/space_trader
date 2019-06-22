package com.example.m4.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PlanetName {
    //enum stuff here

    SIRIUS("Sirius"), CANOPUS("Canopus"), ARCTURUS("Arcturus"), CENTAURI("Centauri"),
    VEGA("Vega"), RIGEL("Rigel"), PROCYON("Procyon"), ACHERNAR("Achernar"), BETELGEUSE("Betelgeuse"),
    HADAR("Hadar"), SPICA("Spica"), ANTARES("Antares"), POLLUX("Pollux"), FOMALHAUT("Fomalhaut"),
    DENEB("Deneb"), MINOSA("Minosa");

    private final String planet;

    PlanetName(String planet) {
        this.planet = planet;
    }

    public static PlanetName getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    @Override
    public String toString() {
        return planet;
    }
}
