package com.example.m4;

import com.example.m4.model.Player;
import com.example.m4.model.Universe;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp() {
        universe = new Universe(12, 30);
        universe.populate();
    }

    @Test
    public void testUniverseSize() {
        String message = "Number of regions should be 12";
        Assert.assertEquals(message, universe.getNumRegions(), 12);
    }

    @Test
    public void testRegionListSize() {
        String message = "Number of regions should be 12";
        Assert.assertEquals(message, universe.getRegions().size(), 12);
    }
}
