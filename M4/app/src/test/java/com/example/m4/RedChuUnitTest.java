package com.example.m4;

import com.example.m4.model.Item;
import com.example.m4.model.Player;
import com.example.m4.model.Universe;
import com.example.m4.model.Region;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class RedChuUnitTest {

    private Universe universe;

    @Test
    public void testPlayer() throws IllegalArgumentException {
        String message = "Total skill points"
                + "cannot exceed 16";
        try {
            new Player("Bender", 16, 16, 16, 16);
            TestCase.fail("Failed to throw exception, invalid number of points");
        } catch (final IllegalArgumentException e) {
            Assert.assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void testPlayerNoException() {
        String message = "Number of skill points is not higher than 16";
        try {
            new Player("Bender", 4, 4, 4, 4);
            Assert.assertTrue("Input total points does not exceed 16", true);
        } catch (final IllegalArgumentException e) {
            TestCase.fail("No exceptions should have been thrown");
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void populate() {
        new Universe(2, 1);
    }

    @Test
    public void testToString() {
        String message = "Number of regions should be 12";
        Universe universe = new Universe(0, 0);
        universe.populate();
        String string = universe.toString();
        Assert.assertEquals(message, "Universe: \n", string);
    }

    @Test
    public void testUniverseSize() {
        String regionMessage = "Number of regions should be 12";
        String planetMessage = "Number of planets should be 30";
        Universe universe = new Universe(12, 30);
        universe.populate();
        Assert.assertEquals(regionMessage, 12, universe.getNumRegions());
        Assert.assertEquals(planetMessage, 30, universe.getNumPlanets());
    }

}
