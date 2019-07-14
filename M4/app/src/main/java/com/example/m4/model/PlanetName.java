package com.example.m4.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Enumerated class that contains all possible names a planet could have
 */
public enum PlanetName {
    //enum stuff here

    SIRIUS("Sirius"), CANOPUS("Canopus"), ARCTURUS("Arcturus"), CENTAURI("Centauri"),
    VEGA("Vega"), RIGEL("Rigel"), PROCYON("Procyon"), ACHERNAR("Achernar"), BETELG("Betelg"),
    HADAR("Hadar"), SPICA("Spica"), ANTARES("Antares"), POLLUX("Pollux"), FOMALH("Fomalh"),
    DENEB("Deneb"), MINOSA("Minosa"), SITULA("Situla"), ALTAIR("Altair"), HAMLA("Hamal"),
    CAPELLA("Capella"), MAAZ("Maaz"), TARF("Tarf"), CHARA("Chara"),
    BOTEIN("Botein"), WEZEN("Wezen"), ALUDRA("Aludra"), DABIH("Dabih"),
    AVIOR("Avior"), CAPH("Caph"), TISH("Tish"), RUCHBAH("Ruchbah");

    private final String planet;

    /**
     * Constructor setting up the name of the planet
     * @param planet
     */
    PlanetName(String planet) {
        this.planet = planet;
    }

    /**
     * Obtains a random number that corresponds to a name in the list
     * @return a planet name
     */
    public static PlanetName getRandom() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    /**
     * Overridden toString method
     * @return planet name
     */
    @Override
    public String toString() {
        return planet;
    }
}
